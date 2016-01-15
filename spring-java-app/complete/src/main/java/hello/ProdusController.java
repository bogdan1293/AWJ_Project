package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;




@RestController
public class ProdusController {
  private List<Produs> produse = new ArrayList<Produs>();

  

PersoanaController() 
{
    Produs p1 = new Produs(1, "Apa minerala",3,"20.11.2016");
    Produs p2 = new Produs(2, "Paine",1,"23.11.2015");
    Produs p3 = new Produs(3, "Lapte",5,"20.12.2015");
    Produs p4 = new Produs(4, "Suc",4,"20.05.2016");

    produse.add(p1);
    produse.add(p2);
    produse.add(p3);
    produse.add(p4);
}


//GET
 
@RequestMapping(value="/Produs", method = RequestMethod.GET)
  

public List<Produs> index() 
{
    return this.produse;
}


//GET

@RequestMapping(value="/Produs/{id_produs}",method=RequestMethod.GET)
  

public ResponseEntity show(@PathVariable("id_produs") int id) 

{
    for(Produs p : this.produse) 
	{
      if(p.getid_produs() == id) 
		{
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      	}
    	}
    
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
 }
  
 

//POST
 @RequestMapping(value="/Produs",method = RequestMethod.POST)
  
public ResponseEntity create()

{
	 produs p5 = new Produs(5,"Bere",6,"23.12.2016");
	 this.produse.add(p5);
	 return new ResponseEntity<Produs>(p5, new HttpHeaders(),HttpStatus.OK);

}
  
  


//PUT

@RequestMapping(value="/produs", method = RequestMethod.PUT)
	

public ResponseEntity update(@PathVariable("id_produs") int id)
{
		for(Produs p : this.persoane)
		{
			if(p.getId_produs() == id)
				{
				p.setId(3);
				p.setNume("Vin");
return new ResponseEntity<produs>(p, new HttpHeaders(), HttpStatus.OK);
				}
		}
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}

  


//DELETE

@RequestMapping(value="/produs/{id_produs}", method = RequestMethod.DELETE)
  
public ResponseEntity remove(@PathVariable("id_produs") int id) 
{
    for(Produs p : this.produse) 
	{
      if(p.getId_produs() == id) 
		{
        this.produs.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      	}
      }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}

}
