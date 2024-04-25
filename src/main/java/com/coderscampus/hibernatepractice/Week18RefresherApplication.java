package com.coderscampus.hibernatepractice;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.hibernatepractice.domain.Account;
import com.coderscampus.hibernatepractice.domain.User;

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
	
	
	//Unit 19
	
	
	//Vid 3 shows how to read the console select statements at 4 minute mark.
	
	//We basically know all that he's going to go over up until Fetching and Cascade types.
	
	
	//Vid 4 goes over basic thymeleaf stuff, action="" is *where* we're sending the data, method=post, 
	//stuff like that. A lot of good things in this video! th:field is how we map front end to back end.
	//Need to map strings? type="text"
	
	
	//Vid 7 - Query Methods 
	//What if we want to use a method that isnt built into JPA Repository?
	//There is a built in method naming convention that allows to query whatever we like, and 
	//this naming convention allows us to access our database. Its Javas equivalent of a select
	//statement.

	//So we want to take this query and return a username, but we can only do that if the user is unique
	//because we want to return only one user. You see? Search a username, get a user. But in order to
	//execute this, we need to add a constraint that allows for only unique usernames. So we need to 
	//add this validation upon the creation of a user. We arent writing this code however. But, if we 
	//have more than one username and only return a User object, it will crash. So we will return a 
	//collection to prevent the crash. not ideal but it will work in the sense of the code not crashing.

	
	//Vid 8 Implementing Query Method
	//i left a note in the service to indicate where the query methods are.
	//Trevor does a mock implementation of the query methods that we created from previous video at minute
	//3 by implementing the find by username method in the /users controller and hard codes a username 
	//thats in the DB. so when he hits that endpoint, the hardcoded username is the only one thats shown. 
	//I wont do this because it feels like a waste, but i will keep this here for reference in case i want 
	//to go back and look.
		
	
	//@ 7 min he does this same example but with the name and username method. he's also hard coding dates
	//in the database for our datetime. he's adding them to show how we can search the date with the 
	//query method. Idk if i want to add this in the DB, but i'm just writing all of this down.
	//between use is 14 min to the end
	
	//There is also a resource on query method formats on the spring website that he talks about - 14 min.
	//remember that all of this is still in the first week 18
	
	
	//Vid 9 Custom Query
	//The naming conventions for the regular query methods dont work, you need to create a more 
	//advanced query.
	
	//for this, the name doesnt matter, but we should still name by convention for consistency sake.
	//Here is the example we'll use: User findOneUSerByUsername(String username);
	//So how does this work? Since our naming convention doesnt connect us to the DB here? Well we 
	//have to annotate this. we say @Query() and within the parameter we add a string that we then
	//user to specify the query. Note that we wont be using native SQL, it will be slightly modified
	//to tailor to Hibernate. Its called JPQL (Java Persistence Querying Language)
	// >>>> @Query("select u from User u where username = :username") 
	//We use alias's, no star, and we dont reference the column we reference the domain.
	
	
	//Vid 10 Eager vs Lazy Fetching
	//So how does a Table fetch data for its respective relationships?
	
	//For example, One to One relationships Eagerly fetch data. What that means is that any 
	//time you fetch the parent object, the child object is also retrieved by default. So if you have a 
	//user object that contains an address, when you fetch a user, the address is also retrieved.
	
	//Now we can add our fetch type to lazy in the one to one relationship, but that doesnt really do
	//much, we would have to go and re design our table entirely. Trevor doesnt go over this because
	//one to one relationships dont happen often. But we will go over _toMany
	
	//_ to Many fetch type default is a lazy fetch, which means that it will only be fetched when
	//explicitly called.
	
	//Lazy is better. Only grab the data if you need it.
	//We did a call in the /users endpoint that will call all accounts for any user that has them to see
	//that the lazy fetch will work, but ONLY when being asked.
	
	//we still have a million select statements though, so we want to clean this up and get all of the data that
	//we need with one select statement
	
	
	//Vid 11 Fixing Performance Issues
	//This will basically consist of doing what this last paragraph of the previous video talks about - 
	//cleaning up the select statements.
	
	//What do we need to do? Modify the method that we are leveraging, in this case it would be the 
	//find all method in our UserController. NOTE that we should only modify these things when we see
	//that there is going to be a problem.
	
	//he says that the root cause is that there is no join on the first statement, we arent joining all 
	//of the data together. He says that to fix this, we need to override the find all method that is 
	//defined by Spring Data JPA with our own custom query. That way when we call this overridden method 
	//in the controller, we get all of the info in the single statement.
	
	//the default statement is "select u from user u", but we need to join another table. See UserRepo class.
	//NOTE: you NEED a space before the word join in the quote.
	//Now we have to change the List<User> to a Set<User> to filter out duplicates, and we also need to
	//override the hashcode and equals in the domain. he explains why at the 11ish minute mark.
	
	
	//Started with this @Query("select u from User u")
	//					List<User>findAll()
	
	//this is what we end with @Query("select u from User u"
	//								+ " left join fetch u.accounts"
	//								+ " left join fetch u.address")
	//							Set<User> findAllOverridden();
	
	//Vid 12 - Saving Data Across Relationships
	//We havent seen how to save an account to the user for example, or a transaction inside of an account,
	//not just a user or account individually.
	
	//So what we'll do for demonstrations sake is whenever we create a brand new user, an account will also
	//be created and saved to that user. How do we implement this? We need to figure out when we're 
	//creating a new account. and we can see that we have a many to many relationship between users
	//and accounts. So how do we populate this? Explained between 2 and 5 minutes. code below
	
	//		if(user.getUserId()==null) {
	//		Account checking = new Account();
	//		checking.setAccountName("Checking Account");
	//		checking.getUsers().add(user);
	//		user.getAccounts().add(checking);
	//		accountRepo.save(checking);
	//		}
	
	//This is also called a bidirectional relationship, accounts points to users and users points to 
	//accounts.
	
	//Vid 13 - Cascade Types
	//When we have information that we are saving within an object and a related entity, like user 
	//and address for example, and we want to save together, we have to look at how they cascade.
	
	//Persist - So a new User object is created, an Address object is automatically created and saved into 
	//the user object, then they are saved together
	
	//Merge - when you have an existing user and you add a new address or updating a new address and you issue
	//a save. adding/updating child will save into the parent.
	
	//Remove - you have an existing user and set the address to null or delete it, then the user is deleted
	
	//Stuck at minute 19ish, my removal isnt working. not sure why, need to look into it some more 
	
}







