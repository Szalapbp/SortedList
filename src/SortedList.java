import java.util.ArrayList;

public class SortedList
{
    private ArrayList<String> list;

    public SortedList()
    {
        list = new ArrayList<>();
    }

    private int binarySearch(String element)
    {
        int low = 0, high = list.size()-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int compare = element.compareTo(list.get(mid));
            if(compare == 0)
            {
                return mid;
            }
            else if(compare > 0)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;

    }

    public void add(String element)
    {
        int index = binarySearch(element);
        list.add(index, element);
    }

    public String search(String element)
    {
        int index = binarySearch(element);
        return(index<list.size() && list.get(index).equals(element)) ?
                "Found at index " + index : "Not found, should be at index " + index;
    }

    public String display()
    {
        return list.toString();
    }


}
