import javax.jms.* ; 
import javax.naming.* ; 
import java.lang.* ; 

public class Emetteur{

    public static void main(String[] args) {
    	try{
        InitialContext context = new InitialContext();
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup("jms/queueConnectionFactory");
		Queue queue = (Queue) context.lookup("jms/queueDestination");
		QueueConnection connection = connectionFactory.createQueueConnection();
		QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		connection.start();
			
        QueueSender sender = session.createSender(queue);
        TextMessage msg = session.createTextMessage();
        msg.setText("Hi, I'm Oussama");
        sender.send(msg);
        }catch(NamingException ne){
			ne.printStackTrace();
		}
		catch(JMSException jmse){
			jmse.printStackTrace();
		}
		 System.exit(0);
    }   

}
