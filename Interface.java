import java.util.Scanner;

interface SmartDevice
{
    void turnOn();
    void turnOff();
}

class SmartFan implements SmartDevice
{
    private int speed;

    public void turnOn()
    {
        System.out.println("Smart Fan is turned ON");
    }

    public void turnOff()
    {
        System.out.println("Smart Fan is turned OFF");
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}

class SmartLight implements SmartDevice
{
    private int brightness;

    public void turnOn()
    {
        System.out.println("Smart Light is turned ON");
    }

    public void turnOff()
    {
        System.out.println("Smart Light is turned OFF");
    }

    public void setBrightness(int level)
    {
        this.brightness = level;
    }
}

class SmartAC implements SmartDevice
{
    private int temperature;

    public void turnOn()
    {
        System.out.println("Smart AC is turned ON");
    }

    public void turnOff()
    {
        System.out.println("Smart AC is turned OFF");
    }

    public void setTemperature(int temp)
    {
        this.temperature = temp;
    }
}

public class SmartHomeDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. Smart Fan");
            System.out.println("2. Smart Light");
            System.out.println("3. Smart AC");
            System.out.println("4. Exit");

            System.out.print("Enter device choice: ");
            int deviceChoice = sc.nextInt();

            if (deviceChoice == 4)
            {
                System.out.println("Exit");
                break;
            }

            SmartDevice device;

            if (deviceChoice == 1)
            {
                device = new SmartFan();
            }
            else if (deviceChoice == 2)
            {
                device = new SmartLight();
            }
            else if (deviceChoice == 3)
            {
                device = new SmartAC();
            }
            else
            {
                System.out.println("Invalid device choice");
                continue;
            }

            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");

            System.out.print("Enter operation choice: ");
            int operationChoice = sc.nextInt();

            if (operationChoice == 1)
            {
                device.turnOn();
            }
            else if (operationChoice == 2)
            {
                device.turnOff();
            }
            else
            {
                System.out.println("Invalid operation choice");
            }
        }

        sc.close();
    }
}
