/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData, tempList;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // just past end of list1
      ) {

	tempList = new ArrayList<String> (end1-start0);
	for( int startIUser = start0; startIUser < end1; startIUser++)
	    tempList.add( usersData.get( startIUser));
	
	int destination = start0;
	start1 -= start0;
	end1 -=start0;
	start0 = 0;
	int boundary = start1;
	
	while ( start0<boundary  && start1<end1 ) {
	    if ( tempList.get(start0).compareTo( tempList.get(start1)) < 0) {
		usersData.set( destination++, tempList.get(start0++));
	    }
	    else {
	        usersData.set( destination++, tempList.get(start1++));
	    }
	    System.out.println( usersData);
	}
	
	while ( start0<boundary ) {
	    usersData.set( destination++, tempList.get(start0++));
	}

	while ( start1<end1 ) {
	    usersData.set( destination++, tempList.get(start1++));	
	}
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) {
                 System.out.println( "trouble between position " + i 
                                  + ", which holds " + usersData.get(i)
                                  + ", and position " + (i +1)
                                  + ", which holds " + usersData.get(i +1)
                                  );
               return false;
            }
        return true;
    }
}
