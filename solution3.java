import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        
        List<Supplier> l1 = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();

            int size = sc.nextInt(); sc.nextLine();
            List<Material> l2 = new ArrayList<>(size);
            for(int j=0;j<size;j++){
                String aa = sc.nextLine();
                String bb = sc.nextLine();
                String cc = sc.nextLine();
                double dd = sc.nextDouble(); sc.nextLine();

                l2.add(new Material(aa,bb,cc,dd));
            }
            l1.add(new Supplier(a, b, l2));
        }

        String cat1 = sc.nextLine();
        String cat2 = sc.nextLine();
        String id = sc.nextLine();

        FindSupplierWithHighestMaterialCount(l1,cat1);
        FindSupplierQualityRating(l1,id,cat2);

    }
    public static void FindSupplierWithHighestMaterialCount(List<Supplier> l1, String cat){
        int maxi = 0;
        String ans="";

        for(Supplier s: l1){
            int cnt=0;
            for(Material m: s.mat){
                if(m.getCategory().equalsIgnoreCase(cat)){
                    cnt++;
                }
            }
            if(cnt>maxi){
                maxi=cnt;
                ans=s.getSupplierId();
            }
        }

        if(ans=="" && maxi==0){
            System.out.println("No supplier supplies materials for "+cat+" category");
        }
        else System.out.println("Supplier supplying most number of materials for "+cat+" category:"+ans);
    }

    public static void FindSupplierQualityRating(List<Supplier> l1, String id, String cat){
        int c=0;
        double sum=0;
        int cnt=0;
        for(Supplier s: l1){
            if(s.getSupplierId().equalsIgnoreCase(id)){
                for(Material m: s.mat){
                    if(s.getSupplierId().equalsIgnoreCase(id) && m.getCategory().equalsIgnoreCase(cat)){
                        sum+=m.getQualityrating();
                        cnt++;
                    }
                }
            }
            else{
                c++;
            }
        }
        if(c==l1.size()){
            System.out.println("No supplier found with ID: "+id);
            return;
        }
        else if(sum!=0 && cnt!=0){ 
            double avg = sum/cnt;
            String str = String.format("%.1f", avg);
            System.out.println("Average quality rating of "+id+" for "+cat+" category:"+str);
            return;
        }
        else if(sum==0 && cnt==0){
            System.out.println("No materials are supplied by "+id+" for "+cat+" category");
            return;
        }
    }
}

class Material{
    String materialId;
    String materialName;
    String category;
    double qualityrating;
    
    public Material(String materialId, String materialName, String category, double qualityrating) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.category = category;
        this.qualityrating = qualityrating;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getQualityrating() {
        return qualityrating;
    }

    public void setQualityrating(double qualityrating) {
        this.qualityrating = qualityrating;
    }

}

class Supplier{
    String supplierId;
    String supplierName;
    List<Material> mat;
    
    public Supplier(String supplierId, String supplierName, List<Material> mat) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.mat = mat;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<Material> getMat() {
        return mat;
    }

    public void setMat(List<Material> mat) {
        this.mat = mat;
    }

    
}

/* 
I/P:
2
s001
supplier1
1
m001
ready-mix
concrete
4.0
s002
supplier2
2
m001
ready-mix
concrete
4.5
m002
precastconcrete
concrete
4.3
concrete
concrete
s001

O/P:
Supplier supplying most number of materials for concrete category:s002
Average quality rating of s001 for concrete category:4.0
No supplier found with ID: s001 -> wrong
*/
