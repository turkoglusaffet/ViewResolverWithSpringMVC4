package com.myapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Car {
	private String name;

	private String model;

	private List<String> feature = new ArrayList<String>();

	public Car() {

	}

	public Car(String name) {
		this.name = name;
		this.model = "2015";
		this.feature.add("Cruise Control");
		this.feature.add("Automatic Shift");
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public List<String> getFeature() {
		return feature;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement
	public void setFeature(List<String> feature) {
		this.feature = feature;
	}
}
