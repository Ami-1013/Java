// Q2- Animal shelter queue problem

class NodeAnimal {
    String value; // dog and cat in lower case.
    NodeAnimal next, before, nextSame;   /* nextOldest for oldest animal & nextSame for next same type of animal in shelter.
    This value will be use for the animal that will come after this animal i.e while enQueuing new animal after this.                                   
    */

    /*
                                       next       
                      <-    <-   <-     <-        <-
                                            !   
    ending(newest)   D    C    C    D        C        D (oldest)    starting
                      ->   ->   ->     ->       ->
                                               before   
    
    */ 

    NodeAnimal(String animal){
        this.value = animal;
    }
}

class Shelter{
    NodeAnimal oldest,newest, newCat, newDog, oldCat, oldDog;
    //  "oldest" & "newest" for oldest and newest animal in the shelter regardless of their species
    

    // empty f
    public boolean isEmpty(){
        return this.oldest == null;
    }

    public boolean noCat(){
        return this.oldCat == null;
    }

    public boolean noDog(){
        return this.oldDog == null;
    }

    private void insertAnimal(NodeAnimal ani){
        this.newest.next = ani;
        ani.before = newest;
        this.newest = ani;


    }

    private void insertCat(NodeAnimal cat){
        this.newCat.nextSame = cat;
        this.newCat = cat;

        insertAnimal(cat);
    }

    private void insertDog(NodeAnimal dog){
        this.newDog.nextSame = dog;
        this.newDog = dog;

        insertAnimal(dog);
    }

    public void traversal(){
        NodeAnimal tempNode = newest;

        System.out.print("Newest** ");
        while(tempNode != null){
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.before;
        }
        System.out.println("**Oldest.");
        
    }
  

    public void enQueueAnimal(String animal){
        NodeAnimal node = new NodeAnimal(animal);
        
        // empty condition
        if (isEmpty()){
            this.oldest = this.newest =  node;
        }

        if (animal == "cat"){
            if (noCat()) {
                this.oldCat = this.newCat = node;
                if (this.oldest == node){
                    return;
                }
            }
            insertCat(node);
        }

        else if (animal == "dog"){
            if (noDog()) {
                this.oldDog = this.newDog = node;
                if (this.oldest == node){
                    return;
                }
            }
            insertDog(node);
        }
    }

    // helper private methods regarding deletion ************************
    private void deleteNodeReference(NodeAnimal ani){
        ani.next.before = ani.before;
        ani.before.next = ani.next;
    }
    private void deleteLastNode(NodeAnimal ani){
        this.newest = newest.before;
        this.newest.next = null;
    }
    private String deleteLastType(NodeAnimal ani){
        System.out.println("This is last "+ ani.value);
        NodeAnimal currentOld;
        if (ani.value == "dog"){
            currentOld = this.oldDog;
        }
        else {
            currentOld = this.oldCat;
        }

        String name = currentOld.value;
        // if animal is at the last.
        if (currentOld == newest){
            deleteLastNode(currentOld);
        }
        else{
            deleteNodeReference(currentOld);
        }
        return name;
    }

    public String deQueueAny(){
        if (isEmpty()){
            System.out.println("The shelter is empty");
            return null;
        }
        String name = oldest.value;
        // oldest.before is null

        if (name == "dog"){
            this.oldDog = oldest.nextSame;
        }
        else {
            this.oldCat = oldest.nextSame;
        }

        if (this.oldest == this.newest){
            this.oldest = this.newest = null;
            System.out.println("Now the shelter is EMPTY.");
        }
        else{
            // "deleteNodeReference" is not used as oldest.before = null and null and null.next is not possible.
            this.oldest = oldest.next;
            this.oldest.before = null;
        }

        return name;
    }

    public String deQueueDog(){
        String name;
        if (oldDog == oldest){
            return deQueueAny();
        }
        // if oldDog == oldest then deleteNodeReference will throw of error because of ani.before.next in it as ani.before = null.
        
        else if (oldDog == null){
            System.out.println("No Dog in the shelter.");
            return null;
        }
        else if (oldDog == newDog){
            name = deleteLastType(oldDog);
            this.oldDog = null;
            return name;
        }

        name = oldDog.value;
        NodeAnimal tempNode = oldDog;
        deleteNodeReference(oldDog);
        oldDog = tempNode.nextSame;

        tempNode = null;
        return name;
    }
    

    public String deQueueCat(){
        String name;
        if (this.oldCat == oldest){
            return deQueueAny();
        }
        else if (oldCat == null){
            System.out.println("No Cat in the shelter");
            return null;
        }
        else if (oldCat == newCat){ 
            name = deleteLastType(this.oldCat);
            this.oldCat = null;
            return name;
        }

        name = oldCat.value;
        NodeAnimal tempNode = oldCat;
        deleteNodeReference(oldCat);
        this.oldCat = tempNode.nextSame;
        tempNode = null;
        
        return name;
    }






}




public class L14_4Queue_ques {
    public static void main(String[] args) {
        
        Shelter q = new Shelter();
        q.enQueueAnimal("dog");
        q.enQueueAnimal("cat");
        q.enQueueAnimal("dog");
        q.enQueueAnimal("cat");
        q.enQueueAnimal("cat");
        q.enQueueAnimal("dog");


        // System.out.println(q.oldest.value);
        // System.out.println(q.newest.value);
        q.deQueueDog();
        q.deQueueDog();
        q.deQueueDog();
        q.deQueueDog();
        
        q.deQueueCat();
        q.deQueueCat();
        q.deQueueCat();
        q.deQueueCat();
    

        q.traversal();


        

    }
}
