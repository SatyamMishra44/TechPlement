import java.util.*;

// Model for a single quiz question
class Question {
    String questionText;
    List<String> options;
    int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctOptionIndex;
    }
}

// Model for a Quiz
class Quiz {
    String title;
    List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void takeQuiz(Scanner scanner) {
        int score = 0;
        System.out.println("\nStarting Quiz: " + title);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }
            System.out.print("Your answer (1-" + q.options.size() + "): ");
            int answer = scanner.nextInt() - 1;
            if (q.isCorrect(answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! Correct answer: " + q.options.get(q.correctOptionIndex));
            }
        }

        System.out.println("\nQuiz Completed. Your Score: " + score + "/" + questions.size());
    }
}

public class QuizGeneratorApp {
    static Map<String, Quiz> quizzes = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n\nQuiz Generator Menu:");
            System.out.println("1. Create a new quiz");
            System.out.println("2. Add question to a quiz");
            System.out.println("3. Take a quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    addQuestionToQuiz();
                    break;
                case 3:
                    takeQuiz();
                    break;
                case 4:
                    System.out.println("Exiting Quiz Generator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void createQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        if (quizzes.containsKey(title)) {
            System.out.println("Quiz with this title already exists.");
            return;
        }
        quizzes.put(title, new Quiz(title));
        System.out.println("Quiz created successfully.");
    }

    static void addQuestionToQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = quizzes.get(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }
        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();

        List<String> options = new ArrayList<>();
        System.out.print("Enter number of options: ");
        int numOptions = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOptions; i++) {
            System.out.print("Option " + (i + 1) + ": ");
            options.add(scanner.nextLine());
        }

        System.out.print("Enter correct option number (1-" + numOptions + "): ");
        int correctIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Question question = new Question(questionText, options, correctIndex);
        quiz.addQuestion(question);
        System.out.println("Question added successfully.");
    }

    static void takeQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = quizzes.get(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }
        quiz.takeQuiz(scanner);
    }
}
