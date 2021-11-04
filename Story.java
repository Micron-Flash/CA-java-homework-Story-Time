import java.util.*;

/**
 * Story
 */
public class Story {

    public static void main(String[] args) {

        //There must be at least 2 actors in the list
        List<String> default_actors = Arrays.asList("child", "frog", "bear", "weasel");
        List<String> new_actors = new ArrayList<>();
        String story = new String();
        Scanner input = new Scanner(System.in);
        System.out.println("Use default actors " + default_actors.toString() + " y/n:");
        String answer = input.nextLine();

        if (answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes")) {

            story = generate_story(default_actors);
            
        } else if (answer.equals("n") || answer.equals("N") || answer.equals("no") || answer.equals("No")) {

            int num_of_actors = 0;
            boolean correct_actor_amount = false;
            
            while (!correct_actor_amount) {
                System.out.println("Number of actors? (Must be 2 or more)");
                num_of_actors = Integer.parseInt(input.nextLine());

                if (num_of_actors >= 2) {
                    correct_actor_amount = true;
                }
            }

            for (int i = 1; i < num_of_actors + 1; i++) {
                System.out.println("Please enter name of actor #" + i + ":");
                String actor = input.nextLine();

                if (actor.length() <= 0) {
                    i--;
                } else {
                    new_actors.add(actor);
                }
            }

            story = generate_story(new_actors);
        }
        System.out.flush();
        System.out.println(story);
        input.close();
    }

    public static String generate_story(List<String> actors) {
        List<String> part1 = new ArrayList<>();
        List<String> part2 = new ArrayList<>();

        // Fisrt line of the story is unique
        String story_start = "\nA " + actors.get(0) + " couldn't sleep, so the " +  actors.get(0) + "'s mother told a story about a little " + actors.get(1) + (",");

        for (int i = 1; i < actors.size() - 1; i++) {
            //Example provided has increasing and decreasing indents. This will 
            String indents = new String();
            for (int j = 0; j < i; j++){
                indents += "  ";
            }
            part1.add("\n" + indents + "who couldn't sleep, so the " + actors.get(i) + "'s mother told a story about a little " + actors.get(i + 1) + ",");
        }
        part2.add("\n");
        for (int i = 0; i < actors.size(); i++) {
            String indents = new String();
            for (int j = 0; j < i; j++){
                indents += "  ";
            }
            part2.add("\n" + indents + "...and the little " + actors.get(i) + " fell asleep.");
        }

        String story = story_start;

        //Combine all the first parts of the story
        for (int i = 0; i < part1.size(); i++) {
            story += part1.get(i);
        }
        //Combine all the second parts of the story
        for (int i = part2.size() - 1; i >= 0; i--) {
            story += part2.get(i);
        }
        return story;
    }
}