import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>guest = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!input.equals("Party!")){
            String []tokens = input.split("\\s+");
            String command = tokens[0];
            String secondCommand = tokens[1];
            if (command.equals("Double")){
               switch (secondCommand){
                   case "Length":
                       int length = Integer.parseInt(tokens[2]);
                       getDouble(guest,length,command);
                       break;
                   case "StartsWith":
                       String startWord = tokens[2];
                       getStartsWord(guest,startWord,command);
                       break;
                   case "EndsWith":
                       String endWord = tokens[2];
                       getEndsWord(guest,endWord,command);
                       break;

               }
            }
            else if (command.equals("Remove")){
                switch (secondCommand){
                    case "Length":
                        int length = Integer.parseInt(tokens[2]);
                        getDouble(guest,length,command);
                        break;
                    case "StartsWith":
                        String startWord = tokens[2];
                        getStartsWord(guest,startWord,command);
                        break;
                    case "EndsWith":
                        String endWord = tokens[2];
                        getEndsWord(guest,endWord,command);
                        break;

                }
            }

            input = scanner.nextLine();
        }
        Collections.sort(guest);
        if (guest.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        else {
            System.out.println(String.join(", ", guest) + " are going to the party!");
        }

    }

    private static void getEndsWord(List<String> guest, String endWord,String seconCommand) {
        int length = endWord.length();
        for (int i = 0; i < guest.size(); i++) {
            if (guest.get(i).substring(guest.get(i).length() - length).equals(endWord)){
                if (seconCommand.equals("Double")){
                    guest.add(0,guest.get(i));
                    i++;
                }
                else if (seconCommand.equals("Remove")){
                    guest.remove(guest.get(i));
                }
            }
        }
    }

    private static void getStartsWord(List<String> guest, String startWord,String seconCommand) {
        int length = startWord.length();
        for (int i = 0; i < guest.size(); i++) {
            if (guest.get(i).substring(0,length).equals(startWord)){
                if (seconCommand.equals("Double")){
                    guest.add(0,guest.get(i));
                    i++;
                }
                else if (seconCommand.equals("Remove")){
                    guest.remove(guest.get(i));
                }

            }
        }
    }

    private static void getDouble(List<String> guest, int length,String seconCommand) {
        for (int i = 0; i < guest.size(); i++) {
            if (guest.get(i).length() == length){
                if (seconCommand.equals("Double")){
                    guest.add(0,guest.get(i));
                    i++;
                }
                else if (seconCommand.equals("Remove")){
                    guest.remove(guest.get(i));
                }

            }
        }
    }
 }