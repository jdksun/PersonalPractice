package com.syl.design;

public class MingLing {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        LightOnCommand onL = new LightOnCommand(light);
        LightOffCommand offL = new LightOffCommand(light);
        remoteControl.setCommand(0,onL,offL);

        Fan fan = new Fan();
        FanHighCommand fH = new FanHighCommand(fan);
        FanLowCommand fL = new FanLowCommand(fan);
        FanOffCommand fO = new FanOffCommand(fan);
        remoteControl.setCommand(1,fH,fO);
        remoteControl.setCommand(2,fL,fO);


        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        System.out.println("-------------多命令");
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
        System.out.println("-------------组合命令");
        MacroCommand macroOnCommand = new MacroCommand(new Command[]{onL,fH});
        MacroCommand macroOFFCommand = new MacroCommand(new Command[]{offL,fO});
        remoteControl.setCommand(3,macroOnCommand,macroOFFCommand);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}

class RemoteControl{
    private Command[] on;
    private Command[] off;
    private Command undo;
    public RemoteControl() {
        on = new Command[9];
        off = new Command[9];
        Command noCommand = new NoCommand();
        for (int i = 0; i < on.length; i++) {
            on[i] = noCommand;
            off[i] = noCommand;
        }
    }

    public void setCommand(int i,Command onC,Command offC){
        on[i] = onC;
        off[i] = offC;
    }
    public void onButtonWasPushed(int slot){
        on[slot].execute();
        undo = on[slot];
    }
    public void offButtonWasPushed(int slot){
        off[slot].execute();
        undo = off[slot];
    }
    public void undoButtonWasPushed(){undo.undo();}
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------- 遥控器 ------------\n");
        for (int i = 0; i < on.length; i++) {
            sb.append("[键 " + i +"] "+on[i].getClass().getName()+" \t"
            +off[i].getClass().getName()+"\n");
        }
        return sb.toString();
    }
}
interface Command{
    public void execute();
    public void undo();
}
class NoCommand implements Command{
    public void execute() {
        System.out.println("没有设置命令");
    }

    public void undo() {

    }
}

class Light{
    public void on(){
        System.out.println("开灯");
    }
    public void off(){
        System.out.println("关灯");
    }
}
class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
class Fan{
    private int speed;
    public void low(){
        speed = 1;
        System.out.println("抵档风扇");
    }
    public void high(){speed = 2;
        System.out.println("高档风扇");}
    public void off(){speed = 0;
        System.out.println("关闭风扇");}

    public int getSpeed() {
        return speed;
    }
}
class FanLowCommand implements Command{
    private Fan fan;
    private int speed;
    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        speed = fan.getSpeed();
        fan.low();
    }

    public void undo() {
        if (speed == 0){
            fan.off();
        }else if (speed == 1){
            fan.low();
        }else {
            fan.high();
        }
    }
}
class FanHighCommand implements Command{
    private Fan fan;
    private int speed;
    public FanHighCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        speed = fan.getSpeed();
        fan.high();
    }

    public void undo() {
        if (speed == 0){
            fan.off();
        }else if (speed == 1){
            fan.low();
        }else {
            fan.high();
        }
    }
}
class FanOffCommand implements Command{
    private Fan fan;
    private int speed;
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        speed = fan.getSpeed();
        fan.off();
    }

    public void undo() {
        if (speed == 0){
            fan.off();
        }else if (speed == 1){
            fan.low();
        }else {
            fan.high();
        }
    }
}
//命令宏
class MacroCommand implements Command{
    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    public void undo() {
        for (int i = 0; i <commands.length ; i++) {
            commands[i].undo();
        }
    }
}