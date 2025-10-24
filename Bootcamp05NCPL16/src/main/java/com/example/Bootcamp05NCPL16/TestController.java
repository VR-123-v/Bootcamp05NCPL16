package com.example.Bootcamp05NCPL16;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String homePage() {
        // Inline HTML with both messages and a nice background
        return """
            <html>
                <head>
                    <title>Bootcamp05NCPL16 - AWS ECS Demo</title>
                    <style>
                        body {
                            margin: 0;
                            padding: 0;
                            height: 100vh;
                            background-image: url('https://images.unsplash.com/photo-1503264116251-35a269479413?auto=format&fit=crop&w=1920&q=80');
                            background-size: cover;
                            background-position: center;
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            color: white;
                            text-align: center;
                            display: flex;
                            flex-direction: column;
                            justify-content: center;
                            align-items: center;
                        }
                        h1 {
                            font-size: 3em;
                            background: rgba(0, 0, 0, 0.6);
                            padding: 15px 30px;
                            border-radius: 10px;
                        }
                        .message-box {
                            background: rgba(0, 0, 0, 0.4);
                            padding: 20px 40px;
                            margin-top: 20px;
                            border-radius: 10px;
                            width: 60%;
                            max-width: 700px;
                        }
                        button {
                            margin-top: 20px;
                            padding: 10px 20px;
                            border: none;
                            background-color: #00bcd4;
                            color: white;
                            font-size: 1.1em;
                            border-radius: 8px;
                            cursor: pointer;
                            transition: background-color 0.3s ease;
                        }
                        button:hover {
                            background-color: #0097a7;
                        }
                        footer {
                            position: absolute;
                            bottom: 15px;
                            width: 100%;
                            font-size: 0.9em;
                            opacity: 0.8;
                        }
                    </style>
                </head>
                <body>
                    <h1>🚀 Bootcamp05NCPL16 | Spring Boot on AWS ECS</h1>
                    
                    <div class="message-box" id="messages">
                        <p>Loading messages...</p>
                    </div>
                    
                    <button onclick="loadMessages()">🔄 Refresh Messages</button>
                    
                    <footer>© 2025 Bootcamp05NCPL16 Project | Powered by AWS ECS</footer>

                    <script>
                        async function loadMessages() {
                            const responses = await Promise.all([
                                fetch('/demo/data'),
                                fetch('/demo/message')
                            ]);
                            const data = await responses[0].text();
                            const message = await responses[1].text();
                            document.getElementById('messages').innerHTML = `
                                <p><strong>Message 1:</strong> ${data}</p>
                                <p><strong>Message 2:</strong> ${message}</p>
                            `;
                        }
                        loadMessages();
                    </script>
                </body>
            </html>
        """;
    }

    @GetMapping("/demo/data")
    public String getData() {
        return "First message from AWS ECS (Bootcamp05NCPL16)";
    }

    @GetMapping("/demo/message")
    public String getMessage() {
        return "Second message from AWS ECS (Bootcamp05NCPL16)";
    }
}
