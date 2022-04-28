package Business.Organization;
import java.util.ArrayList;

/**
 *
 * @author Ching-Fong Chen
 */
public class CampaignOrganization extends Organization  {
    
public CampaignOrganization() {
       super(OrgType.Campaign.getValue());
       ArrayList<Organization> Organization = new ArrayList();
    }