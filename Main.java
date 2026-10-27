//// Task 1
//interface Image {
//    void show();
//}
//
//class RealImage implements Image {
//    String fileName;
//
//    public RealImage(String fileName) {
//        this.fileName = fileName;
//        loadFromDisk();
//    }
//
//    void loadFromDisk() {
//        System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
//    }
//
//    public void show() {
//        System.out.println("Displaying " + fileName + " on screen!");
//    }
//}
//
//class ProxyImage implements Image {
//    RealImage realImage;
//    String fileName;
//    String userRole;
//
//    public ProxyImage(String fileName, String userRole) {
//        this.fileName = fileName;
//        this.userRole = userRole;
//    }
//
//    public void show() {
//        if (!"ADMIN".equals(userRole)) {
//            System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
//            return;
//        }
//        if (realImage == null) {
//            realImage = new RealImage(fileName);
//        }
//        realImage.show();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Image guestPhoto = new ProxyImage("salary_sheet.png", "GUEST");
//        Image adminPhoto = new ProxyImage("salary_sheet.png", "ADMIN");
//
//        guestPhoto.show();
//        adminPhoto.show();
//    }
//}



//// Task 2
//interface Video {
//    void play();
//}
//
//class RealVideo implements Video {
//    String title;
//
//    public RealVideo(String title) {
//        this.title = title;
//        bufferVideo();
//    }
//
//    void bufferVideo() {
//        System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + title);
//    }
//
//    public void play() {
//        System.out.println("Playing video: " + title);
//    }
//}
//
//class ProxyVideo implements Video {
//    RealVideo realVideo;
//    String title;
//    private int viewCount = 0;
//
//    public ProxyVideo(String title) {
//        this.title = title;
//    }
//
//    public void play() {
//        viewCount++;
//        System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");
//
//        if (realVideo == null) {
//            realVideo = new RealVideo(title);
//        }
//        realVideo.play();
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Video video = new ProxyVideo("Cat_Memes.mp4");
//
//        video.play();
//        video.play();
//        video.play();
//    }
//}



//// Task 3
//interface Internet {
//    void connectTo(String site);
//}
//
//class RealInternet implements Internet {
//    public void connectTo(String site) {
//        System.out.println("Connected to site: " + site);
//    }
//}
//
//class SchoolProxyInternet implements Internet {
//    private RealInternet realInternet;
//
//    public void connectTo(String site) {
//        if (site.equals("gaming.com") || site.equals("socialmedia.com")) {
//            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
//            return;
//        }
//        if (realInternet == null) {
//            realInternet = new RealInternet();
//        }
//        realInternet.connectTo(site);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        SchoolProxyInternet internet = new SchoolProxyInternet();
//
//        internet.connectTo("wikipedia.org");
//        internet.connectTo("gaming.com");
//    }
//}



//// Task 4
//// ==========================================
//// THE MACHINE (DOES THE RAW WORK)
//// ==========================================
//
//// The rule: Every machine must be able to turn on, off, and change volume
//interface Device {
//    void turnOn();
//    void turnOff();
//    void setVolume(int volume);
//}
//
//// Machine 1: A TV
//class Tv implements Device {
//    int volume = 20;
//
//    public void turnOn() {
//        System.out.println("TV screen powers ON.");
//    }
//
//    public void turnOff() {
//        System.out.println("TV screen powers OFF.");
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//        System.out.println("TV volume set to: " + this.volume);
//    }
//}
//
//// Machine 2: A Radio
//class Radio implements Device {
//    int volume = 10;
//
//    public void turnOn() {
//        System.out.println("Radio starts playing static/music.");
//    }
//
//    public void turnOff() {
//        System.out.println("Radio goes silent.");
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//        System.out.println("Radio volume knob turned to: " + this.volume);
//    }
//}
//
//
//// ==========================================
//// THE CONTROLLER (THE REMOTE YOU HOLD)
//// ==========================================
//
//class BasicRemote {
//    // THIS VARIABLE IS THE BRIDGE!
//    protected Device device;
//
//    public BasicRemote(Device device) {
//        this.device = device;
//    }
//
//    public void powerOn() {
//        device.turnOn();
//    }
//
//    public void powerOff() {
//        device.turnOff();
//    }
//}
//
//class AdvancedRemote extends BasicRemote {
//
//    public AdvancedRemote(Device device) {
//        super(device);
//    }
//
//    public void mute() {
//        System.out.println("[Remote] Mute button pressed!");
//        device.setVolume(0);
//    }
//}
//
//// ==========================================
//// NEW MACHINE: SMART LIGHT (no remote code touched!)
//// ==========================================
//class SmartLight implements Device {
//    public void turnOn() {
//        System.out.println("Smart Light glows bright white.");
//    }
//
//    public void turnOff() {
//        System.out.println("Smart Light shuts off.");
//    }
//
//    // For a light, "volume" means brightness
//    public void setVolume(int level) {
//        System.out.println("Smart Light brightness set to: " + level + "%");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Device light = new SmartLight();
//        AdvancedRemote remote = new AdvancedRemote(light);
//
//        remote.powerOn();
//        remote.mute();
//    }
//}



//// Task 5
//// ==========================================
//// THE MACHINE (DOES THE RAW WORK)
//// ==========================================
//
//// The rule: Every machine must be able to turn on, off, and change volume
//interface Device {
//    void turnOn();
//    void turnOff();
//    void setVolume(int volume);
//}
//
//// Machine 1: A TV
//class Tv implements Device {
//    int volume = 20;
//
//    public void turnOn() {
//        System.out.println("TV screen powers ON.");
//    }
//
//    public void turnOff() {
//        System.out.println("TV screen powers OFF.");
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//        System.out.println("TV volume set to: " + this.volume);
//    }
//}
//
//// Machine 2: A Radio
//class Radio implements Device {
//    int volume = 10;
//
//    public void turnOn() {
//        System.out.println("Radio starts playing static/music.");
//    }
//
//    public void turnOff() {
//        System.out.println("Radio goes silent.");
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//        System.out.println("Radio volume knob turned to: " + this.volume);
//    }
//}
//
//
//// ==========================================
//// THE CONTROLLER (THE REMOTE YOU HOLD)
//// ==========================================
//
//class BasicRemote {
//    // THIS VARIABLE IS THE BRIDGE!
//    protected Device device;
//
//    public BasicRemote(Device device) {
//        this.device = device;
//    }
//
//    public void powerOn() {
//        device.turnOn();
//    }
//
//    public void powerOff() {
//        device.turnOff();
//    }
//}
//
//class AdvancedRemote extends BasicRemote {
//
//    public AdvancedRemote(Device device) {
//        super(device);
//    }
//
//    public void mute() {
//        System.out.println("[Remote] Mute button pressed!");
//        device.setVolume(0);
//    }
//}
//
//// ==========================================
//// NEW MACHINE: SMART LIGHT (no remote code touched!)
//// ==========================================
//class SmartLight implements Device {
//    public void turnOn() {
//        System.out.println("Smart Light glows bright white.");
//    }
//
//    public void turnOff() {
//        System.out.println("Smart Light shuts off.");
//    }
//
//    // For a light, "volume" means brightness
//    public void setVolume(int level) {
//        System.out.println("Smart Light brightness set to: " + level + "%");
//    }
//}
//
//// ==========================================
//// NEW REMOTE: PARTY REMOTE (no machine code touched!)
//// ==========================================
//class PartyRemote extends BasicRemote {
//
//    public PartyRemote(Device device) {
//        super(device);
//    }
//
//    public void partyMode() {
//        System.out.println("[Party Remote] Pumping up the party!");
//        device.turnOn();
//        device.setVolume(100);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Device radio = new Radio();
//        PartyRemote party = new PartyRemote(radio);
//
//        party.partyMode();
//    }
//}



// Task 6
// ==========================================
// THE WEAPONS (HOW THE DAMAGE IS DEALT)
// ==========================================

interface Weapon {
    void use();
}

class Sword implements Weapon {
    public void use() {
        System.out.println("Slash! Dealing 20 physical damage.");
    }
}

class MagicWand implements Weapon {
    public void use() {
        System.out.println("Zap! Dealing 35 magic damage.");
    }
}


// ==========================================
// THE HEROES (WHO IS FIGHTING)
// ==========================================

abstract class Hero {
    // THIS VARIABLE IS THE BRIDGE:
    // It links the Hero team to the Weapon team
    protected Weapon weapon;

    public Hero(Weapon weapon) {
        this.weapon = weapon;
    }
}

class Knight extends Hero {
    public Knight(Weapon weapon) {
        super(weapon);
    }

    public void attack() {
        weapon.use();
    }
}

class Wizard extends Hero {
    public Wizard(Weapon weapon) {
        super(weapon);
    }

    public void attack() {
        weapon.use();
    }
}


public class Main {
    public static void main(String[] args) {
        Knight swordKnight = new Knight(new Sword());
        swordKnight.attack();

        Knight wandKnight = new Knight(new MagicWand());
        wandKnight.attack();
    }
}
