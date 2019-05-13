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
	int startI = start0;
	int boundary = start1;
	
	while ( start0<boundary  && start1<end1 ) {
	    if ( usersData.get(start0).compareTo( usersData.get(start1)) < 0) {
		tempList.add( usersData.get(start0));
		start0++;
	    }
	    else {
		tempList.add( usersData.get(start1));
		start1++;
	    }
	}

	while ( start0<boundary ) {
	    tempList.add( usersData.get(start0));
	    start0++;
	}

	while (start1<end1 ) {
	    tempList.add( usersData.get(start1));
	    start1++;
	}
	
	for ( int startIUser = startI, startITemp = 0;
	      startIUser<= tempList.size();
	      startIUser++, startITemp ++) {
	    usersData.set( startIUser, tempList.get(startITemp));
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
