package Business.Network;

/**
 *
 * @author Ching-Fong Chen
 */
public abstract class Network {
   private String name;
   private String networkName;

   public Network(String networkName){
        this.networkName = networkName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

    