// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.spikes2212.command.genericsubsystem.GenericSubsystem;

public class ShootSubsystem extends GenericSubsystem {

    private WPI_TalonSRX master;
    private WPI_VictorSPX slave;
    public static final double SPEED = 0.3;

    public ShootSubsystem(WPI_TalonSRX master, WPI_VictorSPX slave) {
        this.master = master;
        this.slave = slave;

        this.master.setInverted(true);
        this.slave.follow(this.master);
    }

    @Override
    public void apply(double speed) {
        this.master.set(speed);
    }

    @Override
    public boolean canMove(double speed) {
        return true;
    }

    @Override
    public void stop() {
        master.stopMotor();
    }
}
