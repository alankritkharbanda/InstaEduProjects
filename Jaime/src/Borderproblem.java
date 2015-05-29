
class politicalentity {
	Cities capital;
	BoundarySegments bs;
	int boundaryLength();
	politicalentity[] neighbours();
	politicalentity[] borderOf();
	int area();
	
	
}
class Countries extends politicalentity implements BoundarySegments{
	States st[];
	Cities [] getCities(){return null;}
	Cities Capital;
	int boundaryLength(){}
	Countries[] neighbours(){}
	Countries[] borderOf(){}
	int area(){}
	Cities capital(){}
	
}
class States extends politicalentity implements BoundarySegments{

	public Cities capital() {
		// TODO Auto-generated method stub
		return null;
	}
	int boundaryLength(){}
	States[] neighbours(){}
	States[] borderOf(){}
	int area();
	

}
class Cities{
	Countries country;
	int distance(Cities c){return 0;}
	Countries getCountry(){return null;}
	Cities [] getCities(){return null;}
}
interface BoundarySegments{
	int boundaryLength();
	politicalentity[] neighbours();
	politicalentity[] borderOf();
	int area();
	Cities capital();
	
	
}
class Rivers implements BoundarySegments{
	int boundaryLength(){};
	politicalentity[] neighbours(){};
	politicalentity[] borderOf(){};
	int area(){};
	Cities getCities(){};
	Countries getCountry(){};

}
public class Borderproblem {

	
}
