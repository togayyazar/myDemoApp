package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
	public static boolean bothContain(Integer[] arry1,ArrayList<Integer> arry2,int value,boolean addToArray) {
		/*This method checks whether given arrays contain the value.If both of them contains the value,method returns true.
		 *addToArray parameter decides that whether method adds the value to arrays which does not contain the value.
		 *If addToArray is true,value will be added to arrays that do not contain the value.
		 *If addToArray is false,method does not perform add operation,it only checks whether the value exists in arry1 and arry2.
		 *If they both contain the value,then method returns true,otherwise returns false.
		 */
		boolean arry1ContainsValue=false;
		boolean arry2ContainsValue=false;
		if(arry1==null||arry2==null) {
			throw new RuntimeException("Arrays must not be null.");
		}
		if(arry1.length==0&&arry2.size()==0) {
			if(addToArray)
				addToIntegerArray(arry1,value);
				arry2.add(value);
			return false;
		}
		
		for(int i=0;i<arry1.length;i++) {
			if(arry1[i]!=null) {
				if(arry1[i]==value) {
					arry1ContainsValue=true;
					break;
				}
			}

		}
		
		for(int i:arry2) {
			if(i==value) {
				arry2ContainsValue=true;
				break;
			}
		}
		
		if(addToArray==true) {//adding operation is allowed.
			
			if(!arry1ContainsValue)
				addToIntegerArray(arry1,value);
			if(!arry2ContainsValue)
				arry2.add(value);
		}
		
		return arry1ContainsValue&&arry2ContainsValue; 
		
	}
	// if there is any empty(null) index in Integer[] array ,indexOfEmpty() returns index of the empty field,otherwise returns -1;
	private static int indexOfEmpty(Integer[] arry1) { 
		int index=-1;
		for(int i=0;i<arry1.length;i++) {
			if(arry1[i]==null) {
				index=i;
				break;
			}
		}
		return index;
	}
	private static void addToIntegerArray(Integer[] arry1,int value) {
		int index=indexOfEmpty(arry1);
			if(index!=-1) 
				arry1[index]=value;
			else
				System.out.println("Since Integer[] is full,no space to add value, adding operation could not be performed on Integer[] array.");
	}
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
	System.out.println("0");	
        get("/", (req, res) -> "Hello, World");
	System.out.println("1");
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
			System.out.println("3");
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          Integer[] inputList2 = new Integer[10];
	  int t=0;
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2[t]=value;
	    t++;
          }
          System.out.println(inputList2);


          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          boolean input4AsBoolean = Boolean.parseBoolean(input4);

          boolean result = App.bothContain(inputList2, inputList,input3AsInt,input4AsBoolean);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

 
}

