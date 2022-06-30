package com.servlet; /**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */

import javax.jms.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

import com.redis.GetFromRedis;
import org.apache.activemq.ActiveMQConnectionFactory;

@WebServlet("/sentMq")
public class SentMqServlet extends HttpServlet {
    // 定义 MQ 连接地址
    private static final String ACTIVE_MQ_URL = "tcp://8.130.17.147:61616";
    // 定义队列名称
    private static final String SENT_NAME = "selectRequest";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = GetFromRedis.getStuId();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        try {
            // 创建连接工厂
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
            // 通过连接工厂，获得连接 Connection
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            // 创建会话
            // 两个参数，第一个叫事务 / 第二个叫签收
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 创建目的地
            Queue queue = session.createQueue(SENT_NAME);// 创建消息的生产者
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage textMessage = session.createTextMessage (id + "," + courseId);// 理解为一个字符串
            messageProducer.send (textMessage);

            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/selectCourse?id="+id+"&courseId="+courseId+"");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
