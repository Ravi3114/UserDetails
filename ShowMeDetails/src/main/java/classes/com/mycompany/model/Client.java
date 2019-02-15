package com.mycompany.model;
public class Client{
  private String fullname;
  private String gender;
  private String[]program_lang;
  private String company;
  public void setFullname(String name1){
    this.fullname=name1;
  }
  public void setGender(String name2){
    this.gender=name2;
  }
  public void setProgram_lang(String[] name3){
    this.program_lang=name3;
  }
  public void setCompany(String name4){
    this.company=name4;
  }
  public String getFullname(){
    return fullname;
  }
  public String getGender(){
    return gender;
  }
  public String[] getProgram_lang(){
    return program_lang;
  }
  public String getCompany(){
    return company;
  }
}
