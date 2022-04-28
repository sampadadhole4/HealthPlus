package Business.Network;
import java.util.ArrayList;

/**
 *
 * @author Ching-Fong Chen
 */
public class Country extends Network{
    private ArrayList<State> stateList;
    private static int count;

    public Country() {
        super(NetworkType.Country.getValue());
        Country country = new ArrayList<>();
        stateList = new ArrayList<>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<State> stateList) {
        this.stateList = stateList;
    }