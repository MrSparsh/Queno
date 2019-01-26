package com.example.prashanjeet.firebase;

import java.util.ArrayList;

/**
 * Created by Mayank on 26-01-2019.
 */

public class ShortestQueueOrder
{
    private static int no_of_queues;
    Integer order_of_queues[];
    ShortestQueueOrder()
    {

    }

//    public static ArrayList<ArrayList<Integer> > getShortestOrder(ArrayList<Integer> disFromUser,ArrayList <ArrayList <Integer> > disOfServices ,ArrayList <ArrayList<Integer> > timeSlotsAvailable,ArrayList<Double> avg_time_queue)
//    {
//        no_of_queues=disFromUser.size();
//        Integer order_of_queues[]=new Integer[no_of_queues+1];
//        ArrayList <Integer> OutputorderOfQueues =new ArrayList<>();
//        ArrayList <Integer> OutptorderOfTime =new ArrayList<>();
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
//            for(int k = 0; k< timeSlotsAvailable.get(first_queue).size(); k++) {
//
//                    ArrayList <Double> current_time=new ArrayList<>();
//                    current_time.add((double)timeSlotsAvailable.get(first_queue).get(k));
//
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
//                        OutptorderOfTime.clear();
//                        OutputorderOfQueues.clear();
//                        for(int l=0;l<no_of_queues;l++)
//                            OutputorderOfQueues.add(order_of_queues[l]);
//                    }
//                }
//        }
//    }

    int findCeil ( int first,int l, int h)
    {
        int ceilIndex = l;

        // Now iterate through rest of the elements and find
        // the smallest character greater than 'first'
        for (int i = l+1; i <= h; i++)
            if (order_of_queues[i] > first && order_of_queues[i] < order_of_queues[ceilIndex])
                ceilIndex = i;

        return ceilIndex;
    }

    void swap(int l,int r)
    {
        int temp=order_of_queues[l];
        order_of_queues[l]=order_of_queues[r];
        order_of_queues[r]=temp;
    }
    void reverse( int l, int h)
    {
        while (l < h)
        {
            swap(l, h);
            l++;
            h--;
        }
    }

    public void nextPermutation()
    {
        int i;
        int size=no_of_queues;
        for ( i = size - 2; i >= 0; --i )
            if (order_of_queues[i] < order_of_queues[i+1])
                break;
        int ceilIndex = findCeil(  order_of_queues[i], i + 1, size - 1 );

        // Swap first and second characters
        swap( i, ceilIndex );

        // reverse the string on right of 'first char'
        reverse( i + 1, size - 1 );

    }
    private static int factorial(int no_of_queues) {
        int fac=1;
        for(int i=2;i<=no_of_queues;i++)
        {
            fac=fac*i;
        }
        return fac;
    }

}
