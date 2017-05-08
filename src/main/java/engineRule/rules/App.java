package engineRule.rules;

import java.util.ArrayList;
import java.util.List;

import ch.maxant.rules.Rule;
import ch.maxant.rules.CompileException;
import ch.maxant.rules.DuplicateNameException;
import ch.maxant.rules.Engine;
import ch.maxant.rules.NoMatchingRuleFoundException;
import ch.maxant.rules.ParseException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoMatchingRuleFoundException
    {
    	User u1 = new User("1", "2", "2", "n6000026");
        Mapping m1 = new Mapping("1", "", "", "", "jc==1","0001");
        Mapping m2 = new Mapping("2", "", "", "", "jc==2","0001");
        Mapping m11 = new Mapping("3", "", "", "", "jc==3","0001");
        Mapping m111 = new Mapping("1","1", "", "", "jc==1 && cc==1","0011");
        Mapping m3 = new Mapping("1","2", "", "", "jc==1 && cc==2","0011");
        Mapping m4 = new Mapping("9", "", "", "", "jc==9","0001");
        Mapping m5 = new Mapping("", "3", "", "5", "cc==3 && uid==5","1010");
        Mapping m6 = new Mapping("", "4", "", "1", "cc==4 && uid==1","1010");
        Mapping m7 = new Mapping("5", "", "", "2", "jc==5 && uid==2","1001");
        Mapping m8 = new Mapping("6", "", "1", "3", "jc==6","0001");
    
        ArrayList<Mapping> mappings = new ArrayList<Mapping>();
        mappings.add(m1);
        mappings.add(m2);
        mappings.add(m11);
        mappings.add(m111);
        mappings.add(m3);
        mappings.add(m4);
        mappings.add(m5);
        mappings.add(m6);
        mappings.add(m7);
        mappings.add(m8);

        
        ArrayList<Rule> rules = new ArrayList<Rule>();
        for (Mapping m  : mappings){
        	rules.add(new Rule("mapping"+m.hashCode(), getExpresion(m,u1), "", Integer.parseInt(m.getPriority(), 2), "mappings"));
        }
        
        try {
			Engine engine = new Engine(rules, true);	
			System.out.println(engine.getMatchingRules(u1).get(0) );
			//System.out.println(best);
		} catch (DuplicateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public static String getExpresion(Mapping mapping, User u){
    	List<String> words = new ArrayList<String>();
    	words.add("jc");
    	words.add("cc");
    	words.add("uid");
    	String exp = "";
    	for (String word : words){
    		
    		if (mapping.getExp().contains(word)){
    			if(exp.isEmpty()){

    			exp = mapping.getExp().replaceAll(word, getPropertyUser(word, u));}
    			else
    				exp = exp.replaceAll(word, getPropertyUser(word, u));

    		}
    			
    	}
    
    	return exp.toString();
    }
    
    public static String getPropertyUser(String property, User u){
    	return ( property.equals("jc") ? u.getJc() : property.equals("cc") ? u.getC() : u.getUid());
    }
}
