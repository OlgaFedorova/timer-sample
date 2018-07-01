package ofedorova;

import java.io.Serializable;

public class MyJobHelper implements Serializable {
	private String someStr;
	
	public MyJobHelper(String s) {
		this.someStr = s;
	}

	public String getSomeStr() {
		return someStr;
	}		
}
