/// Online Quiz Application (Java + HTML, CSS, JavaScript) ///

// 1. Backend - Java (Basic)
import java.util.*;

class Question {
    String questionText, optionA, optionB, optionC, optionD, correctAnswer;

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {
    static List<Question> questions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadQuestions();
        int score = 0;
        for (Question q : questions) {
            System.out.println(q.questionText);
            System.out.println("A: " + q.optionA);
            System.out.println("B: " + q.optionB);
            System.out.println("C: " + q.optionC);
            System.out.println("D: " + q.optionD);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals(q.correctAnswer)) {
                score++;
            }
        }
        System.out.println("Your Score: " + score + "/" + questions.size());
    }

    static void loadQuestions() {
        questions.add(new Question("What is Java?", "Language", "Game", "Software", "None", "A"));
        questions.add(new Question("Who created Java?", "Microsoft", "Apple", "Sun Microsystems", "Google", "C"));
    }
}

// 2. Frontend - HTML + JavaScript
<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div id="quiz-container"></div>
    <button onclick="submitQuiz()">Submit</button>
    <p id="result"></p>

    <script>
        let questions = [
            { questionText: "What is Java?", options: ["Language", "Game", "Software", "None"], correctAnswer: "Language" },
            { questionText: "Who created Java?", options: ["Microsoft", "Apple", "Sun Microsystems", "Google"], correctAnswer: "Sun Microsystems" }
        ];

        function displayQuestions() {
            const container = document.getElementById("quiz-container");
            questions.forEach((q, index) => {
                let optionsHtml = q.options.map(option => `<input type='radio' name='q${index}' value='${option}'>${option}<br>`).join('');
                container.innerHTML += `<p>${q.questionText}</p>${optionsHtml}<br>`;
            });
        }

        function submitQuiz() {
            let score = 0;
            questions.forEach((q, index) => {
                let selected = document.querySelector(`input[name='q${index}']:checked`);
                if (selected && selected.value === q.correctAnswer) {
                    score++;
                }
            });
            document.getElementById("result").innerText = "Your Score: " + score + "/" + questions.length;
        }

        displayQuestions();
    </script>
</body>
</html>

// 3. CSS - styles.css
body { font-family: Arial, sans-serif; padding: 20px; }
button { padding: 10px; margin-top: 10px; }

/// END ///
