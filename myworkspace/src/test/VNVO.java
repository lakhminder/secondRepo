package test;

/**
 * Data Object Contains VN CG information

 *
 * @author Jyosthna
 *
 */

public class VNVO implements Comparable 
{
	
	private String TNTypeCd;
	private String TNNumber;
	private String PortedTelephoneNumberFlag;
	private String PROVIDERTOQCC;
	private String WhitePageListQty;
	private String LocationAlias;
	private String TNCategory;
	private Long TNNumberL;
	
	public VNVO(String tnNumber, Long tnNumberL)
	{
		TNNumber = tnNumber;
		TNNumberL = tnNumberL; 
	}
	public VNVO()
	{
		//empty constructor
	}
	public int compareTo(Object o)
	{
		VNVO vnVO = (VNVO) o;
		return TNNumber.compareTo(vnVO.getTNNumber());
	}
	
	public String getPROVIDERTOQCC() {
		return PROVIDERTOQCC;
	}
	public void setPROVIDERTOQCC(String PROVIDERTOQCC) {
		this.PROVIDERTOQCC = PROVIDERTOQCC;
	}
	public String getTNNumber() {
		return TNNumber;
	}
	public void setTNNumber(String TNNumber) {
		this.TNNumber = TNNumber;
	}
	/*public String getTNType() {
		return TNType;
	}
	public void setTNType(String TNType) {
		this.TNType = TNType;
	}*/
	public String getTNTypeCd() {
	return TNTypeCd;
	}

	public void setTNTypeCd(String TNTypeCd) {
	this.TNTypeCd = TNTypeCd;
	}
	
	public String getTNCategory() {
		return TNCategory;
	}

	public void setTNCategory(String TNCategory) {
		this.TNCategory = TNCategory;
	}
	public String getPortedTelephoneNumberFlag() {
		return PortedTelephoneNumberFlag;
	}
	public void setPortedTelephoneNumberFlag(String PortedTelephoneNumberFlag) {
		this.PortedTelephoneNumberFlag = PortedTelephoneNumberFlag;
	}
	public String getWhitePageListQty() {
		return WhitePageListQty;
	}
	public void setWhitePageListQty(String WhitePageListQty) {
		this.WhitePageListQty = WhitePageListQty;
	}
	public String getLocationAlias() {
		return LocationAlias;
	}
	public void setLocationAlias(String locationAlias) {
		this.LocationAlias = locationAlias;
	}
	public Long getTNNumberL() {
		return TNNumberL;
	}
	public void setTNNumberL(Long numberL) {
		TNNumberL = numberL;
	}
	public String toString() {
		return TNNumber.toString();
	}


}
