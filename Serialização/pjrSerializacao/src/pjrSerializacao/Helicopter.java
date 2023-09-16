package pjrSerializacao;

import java.io.Serializable;
public class Helicopter implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	private String model;
	private float weight;
	
	public Helicopter(String model, float weight) {
		super();
		this.model = model;
		this.weight = weight;
	}
	
	public String toString() {
		return "Helicopter [model=" + model + ", weight=" + weight + "]";
	}
	
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public float getWeight() {
			return weight;
		}
		public void setWeight(float weight) {
			this.weight = weight;
		}
}

