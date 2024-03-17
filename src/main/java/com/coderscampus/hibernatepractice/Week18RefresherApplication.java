package com.coderscampus.hibernatepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week18RefresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week18RefresherApplication.class, args);
	}
	
	//Unit 18
	
	//Video 5 Creating Entities
	//we're going to start with a one to many relationship between the account and transaction
	//so we create account entity first, then transaction
	//he also goes over how to update character lengths when creating tables
	//this video only went over creating entities, but not the actual relationships
	
	
	//Video 6 One To Many 
	//on to the relationship. So to start this, we have a one to many, and a many to one.
	//think about it. one to many, many to one. We take out accounts and transactions,
	//there is one account to many transactions, so we take the parent, account, and 
	//annotate it with one to many, and we take the child, transactions, and we annotate
	//that with many to one. you see?
	
	//well we get the concept, now what do we annotate? Well we have to inject the child objects
	//into the parent. Now one account can be mapped to many transactions, so in our accounts entity
	//we need to create a field that represents many transactions. How? we create a list of transactions.
	// private List<Transaction> transactions = new ArrayList<>(); Then we annotate that with
	//our one to many.
	
	//and now we sort of do the same thing with the transaction class. only it isnt a list of
	//accounts because this is out many to one side. So we will inject just out account class.
	//public Account account; 
	
	//Now we go back to the parent side of the relationship because we need to tell it what
	//variable we used to map this. so in Account class we say:
	//@OneToMany(mappedBy = "account"
	//private List<Transaction> transactions = new ArrayList<>();
	
	//Side note, if you need info on how to drop a column that had a foreign key constraint, refer to
	//Unit 18, video 6, around 12:40
	
	
	//Video 7 Many To Many
	//lets start within the user entity and we'll create the relationship to the accounts table.
	//so to do a many to many, we map this many like we did the many in the previous example, with a 
	//collection. only this time we annotate it with an @JoinTable as well since our many to many 
	//relationships are joined by their own table. Now within this we need to specify a few things.
	//we have the name, and the join columns. this is where we specify the name of the table and map
	//where the columns are coming from, similar to the mappedBy. So we'll list the join column, which
	//will be names after the parent pk, and the inverse join column, named by the child pk.
	
	//now we do the came thing in account, only we use the mappedBy annotation within the relationship
	//rather than the join annotations. and we just map it with the variable used.
	
	//Video 8 Mapping a One to One
	//For this we're going to user the Address and User entities. And remember that the address has a 
	//user id as the primary key as well as the foreign key. Now note that when mapping relationships
	//its Object to Object, and in our address fields we dont have one to map the User FK, so we have to add
	//a "private User user;" field in order to map this. And on the verse, we need to add "private 
	//Address address" to the user entity. 
	
	//now on the parent side, the user, we add out annotation and the mappedBy to out child variable and
	//thats pretty much it. then on the child side we have the relationship annotation, and we have 
	//a new annotation, @MapsId. This is what will allow us to create a column as a PK as well as a FK.
	
	//Unit 19 Vid 3 shows how to read the console select statements at 4 minute mark.
	
	//We basically know all that he's going to go over up until Fetching and Cascade types.
	
	//Vid 4 goes over basic thymeleaf stuff, action="" is *where* we're sending the data, method=post, 
	//stuff like that. A lot of good things in this video! th:field is how we map front end to back end.
	//Need to map strings? type="text"
	
}







