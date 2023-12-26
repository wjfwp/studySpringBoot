package com.simple.basic.command;

public class BuilderVOP {
	
	private String name;
	private int age;
	
	public static Builder builder() {
		return new Builder();
	}
	
	private BuilderVOP(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}
	
	public static class Builder{
		
		private String name;
		private int age;
		
		private Builder() {
			
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public BuilderVOP build() {
			BuilderVOP vop = new BuilderVOP(this);
			return vop;
		}
		
	}
	
}
