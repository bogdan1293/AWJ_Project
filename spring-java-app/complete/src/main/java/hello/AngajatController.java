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
public class AngajatController {
  private List<Angajat> angajati = new ArrayList<Angajat>();

  

AngajatController() 
{
    Angajat a1 = new Angajat(1, "Ion Ionescu","contabil,2000);
    Angajat a2 = new Angajat(2, "Alin Paun","manager",3000);
    Angajat a3 = new Angajat(3, "Elena Lupu","femeie de serviciu",1000);
    Angajat a4 = new Angajat(4, "Alex Vasile","paznic",1200);
    angajati.add(a1);
    angajati.add(a2);
    angajati.add(a3);
    angajati.add(a4);
}
//GET
 
@RequestMapping(value="/Angajat", method = RequestMethod.GET)
  
public List<Angajat> index() 
{
    return this.angajati;
}
//GET
@RequestMapping(value="/Angajat/{id_ang}",method=RequestMethod.GET)
  
public ResponseEntity show(@PathVariable("id_ang") int id) 
{
    for(Angajat p : this.Angajati) 
	{
      if(p.getid_ang() == id) 
		{
        return new ResponseEntity<Produs>(a, new HttpHeaders(), HttpStatus.OK);
      	}
    	}
    
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
 }
  
 
//POST
 @RequestMapping(value="/Angajat",method = RequestMethod.POST)
  
public ResponseEntity create()
{
	 Angajat p5 = new Angajat(5, "Alex Stoica","paznic",1300);
	 this.angajati.add(a5);
	 return new ResponseEntity<Produs>(a5, new HttpHeaders(),HttpStatus.OK);
}
  
  
//PUT
@RequestMapping(value="/Angajat", method = RequestMethod.PUT)
	
public ResponseEntity update(@PathVariable("id_ang") int id)
{
		for(Angajat p : this.Angajati)
		{
			if(p.getId_ang() == id)
				{
				p.setId(3);
				p.setNume("Gica Contra");
return new ResponseEntity<Angajat>(a, new HttpHeaders(), HttpStatus.OK);
				}
		}
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}
  
//DELETE
@RequestMapping(value="/Angajat/{id_ang}", method = RequestMethod.DELETE)
  
public ResponseEntity remove(@PathVariable("id_ang") int id) 
{
    for(Angajat p : this.angajati) 
	{
      if(p.getId_ang() == id) 
		{
        this.angajati.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      	}
      }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}
}
