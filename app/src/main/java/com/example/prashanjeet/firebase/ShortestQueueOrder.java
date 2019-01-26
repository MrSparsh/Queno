package com.example.prashanjeet.firebase;

/**
 * Created by Mayank on 26-01-2019.
 */

public class ShortestQueueOrder
{
    Integer order_of_queues[];

    ShortestQueueOrder()
    {

    }

//    public static ArrayList<ArrayList<Integer> > getShortestOrder(ArrayList<Integer> disFromUser,ArrayList <ArrayList <Integer> > disOfServices ,ArrayList <ArrayList<Integer> > timeSlotsAvailable,ArrayList<Double> avg_time_queue)
//    {
//        int no_of_queues=disFromUser.size();
//        Integer order_of_queues[]=new Integer[no_of_queues+1];
//        ArrayList <Integer> orderOfQueues =new ArrayList<>();
//        ArrayList <Integer> orderOfTime =new ArrayList<>();
//        for(int i=0;i<no_of_queues;i++)
//        {
//            order_of_queues[i]=i;
//        }
//        double min_time=1000000000;
//        int index_of_min_queue;
//        int index_of_time;
//        int no_of_permutation=factorial(no_of_queues);
//        for(int i=1;i<=no_of_permutation;i++)
//        {
//            double intial_time;
//            double cur_time;
//            int first_queue=order_of_queues[0];
//
//            int previous_queue=order_of_queues[0];
//
//            for(int k = 0; k< timeSlotsAvailable.get(first_queue).size(); k++) {
//                    intial_time=timeSlotsAvailable.get(first_queue).get(k);
//                    cur_time = intial_time+avg_time_queue.get(first_queue);
//                    for(int l=1;l<no_of_queues;l++)
//                    {
//                        int current_queue_no=order_of_queues[l];
//                        double distance=disOfServices.get(previous_queue).get(current_queue_no);
//                        cur_time+=(distance)/20;
//                        int m;
//                        for(m=0;m<timeSlotsAvailable.get(current_queue_no).size();m++)
//                            if(timeSlotsAvailable.get(current_queue_no).get(m)>=cur_time)
//                                break;
//
//                        cur_time=timeSlotsAvailable.get(current_queue_no).get(m)+avg_time_queue.get(current_queue_no);
//                        previous_queue=current_queue_no;
//                    }
//                    double total_time=cur_time-intial_time;
//                    if(total_time<min_time)
//                    {
//                        index_of_min_queue=first_queue;
//                        index_of_time=k;
//
//                    }
//                }
//        }
//    }

    private static int factorial(int no_of_queues) {
        return 0;
    }

}
