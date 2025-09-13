import java.io.*;
import java.net.*;

public class BeautifulSite {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("🚀 Сайт запущено: http://localhost:8080");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }
    
    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        
        String request = in.readLine();
        if (request == null) return;
        
        String[] parts = request.split(" ");
        if (parts.length < 2) return;
        
        String path = parts[1];
        String response = "";
        
        if (path.equals("/")) {
            response = getHomePage();
        } else if (path.equals("/about")) {
            response = getAboutPage();
        } else if (path.equals("/contact")) {
            response = getContactPage();
        } else {
            response = getHomePage();
        }
        
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html; charset=utf-8");
        out.println("Connection: close");
        out.println();
        out.println(response);
        
        clientSocket.close();
    }
    
    private static String getHomePage() {
        return "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Головна</title><style>" +
               "body { font-family: Arial; background: linear-gradient(135deg, #667eea, #764ba2); margin: 0; padding: 0; color: white; }" +
               ".navbar { background: rgba(255,255,255,0.1); padding: 20px; text-align: center; }" +
               ".navbar a { color: white; text-decoration: none; margin: 0 20px; font-size: 18px; }" +
               ".hero { text-align: center; padding: 100px 20px; }" +
               ".hero h1 { font-size: 48px; margin-bottom: 20px; }" +
               ".btn { background: #ff6b6b; color: white; padding: 15px 30px; text-decoration: none; border-radius: 25px; display: inline-block; margin: 10px; }" +
               ".features { display: flex; justify-content: center; gap: 30px; padding: 50px 20px; }" +
               ".feature { background: rgba(255,255,255,0.1); padding: 30px; border-radius: 15px; text-align: center; width: 250px; }" +
               ".footer { background: rgba(0,0,0,0.3); text-align: center; padding: 30px; margin-top: 50px; }" +
               "</style></head><body>" +
               "<div class='navbar'>" +
               "<a href='/'>Головна</a>" +
               "<a href='/about'>Про нас</a>" +
               "<a href='/contact'>Контакти</a>" +
               "</div>" +
               "<div class='hero'>" +
               "<h1>Ласкаво просимо! 🎉</h1>" +
               "<p>Найкращий сайт на Java</p>" +
               "<div>" +
               "<a href='/about' class='btn'>Дізнатися більше</a>" +
               "<a href='/contact' class='btn'>Зв'язатися</a>" +
               "</div>" +
               "</div>" +
               "<div class='features'>" +
               "<div class='feature'>" +
               "<h3>⚡ Швидко</h3>" +
               "<p>Наш сайт працює дуже швидко</p>" +
               "</div>" +
               "<div class='feature'>" +
               "<h3>🎨 Красиво</h3>" +
               "<p>Сучасний дизайн</p>" +
               "</div>" +
               "<div class='feature'>" +
               "<h3>🔧 Надійно</h3>" +
               "<p>Працює на Java</p>" +
               "</div>" +
               "</div>" +
               "<div class='footer'>" +
               "<p>&copy; 2024 Найкращий сайт</p>" +
               "</div>" +
               "</body></html>";
    }
    
    private static String getAboutPage() {
        return "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Про нас</title><style>" +
               "body { font-family: Arial; background: linear-gradient(135deg, #667eea, #764ba2); margin: 0; padding: 0; color: white; }" +
               ".navbar { background: rgba(255,255,255,0.1); padding: 20px; text-align: center; }" +
               ".navbar a { color: white; text-decoration: none; margin: 0 20px; font-size: 18px; }" +
               ".content { max-width: 800px; margin: 50px auto; padding: 40px; background: rgba(255,255,255,0.1); border-radius: 15px; }" +
               ".footer { background: rgba(0,0,0,0.3); text-align: center; padding: 30px; margin-top: 50px; }" +
               "</style></head><body>" +
               "<div class='navbar'>" +
               "<a href='/'>Головна</a>" +
               "<a href='/about'>Про нас</a>" +
               "<a href='/contact'>Контакти</a>" +
               "</div>" +
               "<div class='content'>" +
               "<h1>Про нашу команду</h1>" +
               "<p>Ми - група ентузіастів, які люблять створювати круті сайти на Java!</p>" +
               "<p>Наша місія - показати, що Java може бути не лише для серверів, але і для гарних веб-сайтів.</p>" +
               "<h2>Наші переваги:</h2>" +
               "<ul>" +
               "<li>✅ Досвідчені розробники</li>" +
               "<li>✅ Сучасні технології</li>" +
               "<li>✅ Якісний код</li>" +
               "<li>✅ Швидка робота</li>" +
               "</ul>" +
               "</div>" +
               "<div class='footer'>" +
               "<p>&copy; 2024 Найкращий сайт</p>" +
               "</div>" +
               "</body></html>";
    }
    
    private static String getContactPage() {
        return "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Контакти</title><style>" +
               "body { font-family: Arial; background: linear-gradient(135deg, #667eea, #764ba2); margin: 0; padding: 0; color: white; }" +
               ".navbar { background: rgba(255,255,255,0.1); padding: 20px; text-align: center; }" +
               ".navbar a { color: white; text-decoration: none; margin: 0 20px; font-size: 18px; }" +
               ".content { max-width: 600px; margin: 50px auto; padding: 40px; background: rgba(255,255,255,0.1); border-radius: 15px; }" +
               ".form-group { margin-bottom: 20px; }" +
               ".form-group label { display: block; margin-bottom: 5px; }" +
               ".form-group input, .form-group textarea { width: 100%; padding: 10px; border: none; border-radius: 5px; }" +
               ".btn { background: #ff6b6b; color: white; padding: 15px 30px; border: none; border-radius: 25px; cursor: pointer; }" +
               ".footer { background: rgba(0,0,0,0.3); text-align: center; padding: 30px; margin-top: 50px; }" +
               "</style></head><body>" +
               "<div class='navbar'>" +
               "<a href='/'>Головна</a>" +
               "<a href='/about'>Про нас</a>" +
               "<a href='/contact'>Контакти</a>" +
               "</div>" +
               "<div class='content'>" +
               "<h1>Зв'яжіться з нами</h1>" +
               "<form>" +
               "<div class='form-group'>" +
               "<label>Ваше ім'я:</label>" +
               "<input type='text' required>" +
               "</div>" +
               "<div class='form-group'>" +
               "<label>Ваш email:</label>" +
               "<input type='email' required>" +
               "</div>" +
               "<div class='form-group'>" +
               "<label>Повідомлення:</label>" +
               "<textarea rows='5' required></textarea>" +
               "</div>" +
               "<button type='submit' class='btn'>Надіслати</button>" +
               "</form>" +
               "<div style='margin-top: 30px;'>" +
               "<h3>Контактна інформація:</h3>" +
               "<p>📧 Email: info@site.com</p>" +
               "<p>📞 Телефон: +380 (12) 345-67-89</p>" +
               "<p>📍 Адреса: м. Київ, вул. Головна, 1</p>" +
               "</div>" +
               "</div>" +
               "<div class='footer'>" +
               "<p>&copy; 2024 Найкращий сайт</p>" +
               "</div>" +
               "</body></html>";
    }
}