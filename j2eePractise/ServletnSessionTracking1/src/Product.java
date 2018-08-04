class Product
{
  private String prod_name;
  private int qty_ordered;
  
  public Product(String pName,int qty)
  {
  	prod_name = pName;
  	qty_ordered = qty;
  }
 public String getName()
 {
    return(prod_name);
  }
 public int getqty()
 {
    return(qty_ordered);
  }
}