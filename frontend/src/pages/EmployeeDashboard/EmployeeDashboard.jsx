import ClockInOutWidget from './components/clockInOutWidget/ClockInOutWidget.jsx'
import AttendanceCard from './components/attendanceCard/AttendanceCard.jsx'
import GreetingMessage from './components/greetingMessage/GreetingMessage.jsx'
import CustomDate from './components/customDate/CustomDate.jsx'
import styles from "./EmployeeDashboard.module.css";

import { useNavigate } from 'react-router-dom';

import { useState } from 'react';

import { useUser } from '../../UserContext';


const EmployeeDashboard = () =>

{
    const { userInfo } = useUser();

    const navigate = useNavigate();
    const navigateToMyAttendance = (e) => {
        e.preventDefault();
        console.log('My Attendance button clicked')
        navigate('/attendance')

        }


    return (
        <>

        <div className={styles.dashboardWrapper}>
            <div className={styles.dashboardGreeting}>
                {userInfo && <GreetingMessage firstName={userInfo.firstName} />}

<CustomDate />
                </div>
                <div className={styles.dashboardContent}>
                    <div className={styles.clockInOutWidget}>
                        <ClockInOutWidget />
                        </div>
                        <div className={styles.attendanceSection}>
                            <div className={styles.attendanceHeader}>
                                <h2>My Attendance</h2>
                                <button type="button" onClick={navigateToMyAttendance} className={styles.forwardButtonContainer}><img src="./././public/images/ForwardArrow.svg" className={styles.forwardButton} />
                                </button>
                                </div>
                                        <AttendanceCard test="Hello World" />
                                        <AttendanceCard test="Hello World" />
                                        <AttendanceCard test="Hello World" />
                            </div>
                    </div>

            </div>

        </>);}

        export default EmployeeDashboard;

