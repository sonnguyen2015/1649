import java.util.Scanner;

public class main {

      public static Stack<String> myStack= new Stack<>();
      public static Queue<String> myQueue=new Queue<>();
      public static Queue<String> getMyQueue= new Queue<>();
      public static Stack<String> getMyStack= new Stack<>();

    public static String Mess(){

        Scanner input = new Scanner(System.in);
        System.out.println("Please input a message:");
        String mess = input.nextLine();
        if (mess.length() > 250) {
            throw new IllegalStateException("This message is over 250 characters");
        }
        if(mess.equals("")){
            throw new IllegalStateException("This message is null");
        }
        return mess;

    }
    public static void MakeMessage() {

        try {
            String mess = Mess();
            if (mess != null && mess.length() <= 250 && mess.length() > 0) {
                myQueue.offer(mess);
                System.out.println("Your message: "+ mess);
            } else {
                throw new IllegalStateException("Wrong imput: ");
            }
//            var messages = mess.split("/");
//      for(int i = 0; i < messages.length; i++) {
//          if (messages[i].equals("")) {
//              throw new IllegalStateException("This small message is null");
//          }
//          try {
//              myQueue.offer(messages[i].trim());
//              System.out.println("Your mess: "+mess);
//              System.out.println(mess.length());
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Please input a valid message");
            MakeMessage();
        }
    }

//          }
//     public static void SendMessage(){
//        while (!myQueue.isEmpty()){
//        Transfer();
//        ReceiveMessage();}
//     }

    public static boolean Transfer(){
        try{
            while(myQueue.size()>0){
               myStack.push(myQueue.poll());
//                System.out.println("Message1:"+myStack.peek());
//                System.out.println(myStack.size());
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean SendMessage(){
        try{
            while (myStack.size()>0){
                getMyStack.push(myStack.pop());
//                System.out.println("Message2:"+getMyStack.peek());
            }

            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean ReceiveMessage(){
        try{
            while(getMyStack.size()>0){
                getMyQueue.offer(getMyStack.pop());
//                System.out.println("Message3:"+getMyQueue.peek());
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static void SendAllMess(){
        if(myQueue.isEmpty()){
            System.out.println("Empty message!");
        }
        else if(Transfer()) {
            if(SendMessage()){
                if(ReceiveMessage()){
                    System.out.println("Message have been sent.");
                }
            }
        }
    }
    public static void GetMessage(){
        String[] temp = new String[getMyQueue.size()];
        System.out.printf(getMyQueue.isEmpty() ? "Empty Message.\n" : "Your message: ");
        try {
            for (int i = 0; getMyQueue.size() >= 1; i++) {
                temp[i] = getMyQueue.poll();
                System.out.print("\"" + temp[i] + (getMyQueue.size() != 0 ? "\", " : "\".\n")); //reused from above
            }
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to view the inbox.");
            System.out.println(e);
        }
    }
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            long startTime = System.currentTimeMillis();
            while (true) {
                System.out.println("************************************");
                System.out.println("         1. Made message.");
                System.out.println("         2. Send messages.");
                System.out.println("         3. View message.");
                System.out.println("         4. Exit.");
                System.out.println("************************************");
                System.out.print("Enter option to continue: ");

                String key = scanner.next();
                scanner.nextLine();
                switch (key) {
                    case "1":
                        MakeMessage();
                        break;
                    case "2":
                        SendAllMess();
                        break;
                    case "3":
                        GetMessage();
                        break;
                    case "4":
                        {return;}
                    default:
                        System.out.println("Invalid input, please try again.");
                }
                long endTime = System.currentTimeMillis();
                double time = (endTime - startTime)/1000.0;
                System.out.println("The time executing in the Process: " + time);
        }
    }
}

