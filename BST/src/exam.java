
public class exam {
	private int Id;
	private String context;
	private String selectA;
	private String selectB;
	private String selectC;
	private String selectD;
	private int ans;
	
	public exam(int Id,String context,String selectA,String selectB,String selectC,String selectD,int ans){
		this.Id = Id;
		this.context = context;
		this.selectA = selectA;
		this.selectB = selectB;
		this.selectC =selectC;
		this.selectD = selectD;
		this.ans = ans;
	}
	
	public String getAllContext(){
		return context +"\nA:"+ selectA +"\tB:"+ selectB +"\tC:"+ selectC+"\tD:" +selectD;
	}
	public int getId(){
		return Id;
	}
}
