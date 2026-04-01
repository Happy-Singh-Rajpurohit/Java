import java.util.*;

public class JobsSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);  //lambda expression to sort the jobs in decreasing order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        //print seq
        System.out.println("The sequence of jobs is: ");
        for(int i=0; i<seq.size(); i++){
           System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
