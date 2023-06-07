using Lab1.D;
using Lab1.O;
using Lab1.S;


//S
var pc1 = new PC("aerocool", "nvidia");
pc1.TurnOff();
pc1.TurnOn();
pc1.RenderImage();

var pc2 = new PC2("deepcool", new Videocard("amd"));
pc2.TurnOff();
pc2.TurnOn();


//O
var pc3 = new OpenClosedPC("deepcool", new Processor("amd".ToLower(), 4));
var pc4 = new OpenClosedPC("deepcool", new Processor("intel".ToLower(), 6));
pc3.ChangeProcessor("elbrus", 12);

var pc5 = new OpenClosedPC2("aerocool", new AmdProcessor(6));
pc5 = new OpenClosedPC2("aerocool", new IntelProcessor(5));
pc5.ChangeIntelProcessor(12);


//L


//I


//D
var car1 = new Car();
car1.BurnFuel();
car1.TurnOn();

var car2 = new Car2(new BoschEngine());
car2.TurnOn();
car2 = new Car2(new ToyotaEngine());
car2.TurnOn();