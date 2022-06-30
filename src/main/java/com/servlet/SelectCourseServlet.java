package com.servlet; /**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.Dao.selectDao;

@WebServlet("/selectCourse")
public class SelectCourseServlet extends HttpServlet {
    // 定义 MQ 连接地址
    private static final String ACTIVE_MQ_URL = "tcp://8.130.17.147:61616";
    // 定义队列名称
    private static final String RECEIVE_NAME = "selectRequest";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        int courseId = 0;
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
            Queue queue = session.createQueue(RECEIVE_NAME);// 5、创建消费者
            MessageConsumer messageConsumer = session.createConsumer(queue);

            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            String message = textMessage.getText();
            System.out.println("收到选课消息" + message);
            id = Integer.parseInt(message.split(",")[0]);
            courseId = Integer.parseInt(message.split(",")[1]);

            messageConsumer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
        selectDao.newSelect(id, courseId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showSelect?id="+id+"");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
