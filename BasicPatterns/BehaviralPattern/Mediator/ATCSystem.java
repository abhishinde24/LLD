import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface Mediator {
    void requestLanding(Aircraft aircraft);
    void registerFlight(Aircraft aircraft);
}

// Concrete Mediator: AirTrafficController
class AirTrafficController implements Mediator {
    private List<Aircraft> flights = new ArrayList<>();

    @Override
    public void registerFlight(Aircraft aircraft) {
        flights.add(aircraft);
    }

    @Override
    public void requestLanding(Aircraft requestingAircraft) {
        for (Aircraft aircraft : flights) {
            if (aircraft != requestingAircraft) {
                if (aircraft.getAltitude() < requestingAircraft.getAltitude()) {
                    System.out.println("Permission denied for " + requestingAircraft.getFlightNumber() +
                            ". " + aircraft.getFlightNumber() + " is at a lower altitude.");
                    return;
                }
            }
        }
        System.out.println("Landing initiated for " + requestingAircraft.getFlightNumber());
    }
}

// Abstract Component: Aircraft
abstract class Aircraft {
    private String flightNumber;
    private int altitude;
    private Mediator mediator;

    public Aircraft(String flightNumber, int altitude, Mediator mediator) {
        this.flightNumber = flightNumber;
        this.altitude = altitude;
        this.mediator = mediator;
        mediator.registerFlight(this);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAltitude() {
        return altitude;
    }

    public void land() {
        mediator.requestLanding(this);
    }
}

// Concrete Components: Flights
class QatarAirways extends Aircraft {
    public QatarAirways(String flightNumber, int altitude, Mediator mediator) {
        super(flightNumber, altitude, mediator);
    }
}

class SingaporeAirlines extends Aircraft {
    public SingaporeAirlines(String flightNumber, int altitude, Mediator mediator) {
        super(flightNumber, altitude, mediator);
    }
}

class AllNipponAirways extends Aircraft {
    public AllNipponAirways(String flightNumber, int altitude, Mediator mediator) {
        super(flightNumber, altitude, mediator);
    }
}

class CathayPacificAirways extends Aircraft {
    public CathayPacificAirways(String flightNumber, int altitude, Mediator mediator) {
        super(flightNumber, altitude, mediator);
    }
}

// Main Class to Test the Implementation
public class ATCSystem {
    public static void main(String[] args) {
        // Create the mediator (ATC)
        Mediator atc = new AirTrafficController();

        // Create flights and register them with the mediator
        Aircraft qaFlight = new QatarAirways("QA2341", 4000, atc);
        Aircraft saFlight = new SingaporeAirlines("SA9354", 2000, atc);
        Aircraft anaFlight = new AllNipponAirways("AN2344", 1000, atc);
        Aircraft cpaFlight = new CathayPacificAirways("CP2976", 3000, atc);

        // Request landing for flights
        saFlight.land(); // Permission denied (lower altitude flights exist)
        anaFlight.land(); // Landing initiated (lowest altitude)
        qaFlight.land(); // Permission denied (lower altitude flights exist)
        cpaFlight.land(); // Permission denied (lower altitude flights exist)
    }
}