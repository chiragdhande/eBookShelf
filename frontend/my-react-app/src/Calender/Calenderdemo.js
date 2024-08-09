import React, { useState, useEffect } from "react";
import "./Calendercss.css";

const CalendarDemo = ({ onDifferenceChange }) => {
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");

  const handleDateChange = (event) => {
    const selectedDate = event.target.value;
    if (event.target.name === "Start") {
      setStartDate(selectedDate);
    } else {
      setEndDate(selectedDate);
    }
  };

  useEffect(() => {
    calculateDateDifference(startDate, endDate);
  }, [startDate, endDate]);

  const calculateDateDifference = (start, end) => {
    if (start && end) {
      const startDateObj = new Date(start);
      const endDateObj = new Date(end);
      console.log(end);
      const difference = Math.floor(
        (endDateObj - startDateObj) / (1000 * 60 * 60 * 24)
      );
      onDifferenceChange(difference, end,start);
    }
  };

  return (
    <div>
      <div className="date-container">
        <label htmlFor="startDate">Start date</label>
        <input
          type="date"
          name="Start"
          id="startDate"
          required
          value={startDate}
          onChange={handleDateChange}
          min={new Date().toISOString().split("T")[0]} // Set minimum date to current date
        />
      </div>
      <div className="date-container">
        <label htmlFor="endDate">End date</label>
        <input
          type="date"
          name="End"
          id="endDate"
          required
          value={endDate}
          onChange={handleDateChange}
          min={startDate} // Set minimum date to current selected date
        />
      </div>
    </div>
  );
};

export default CalendarDemo;
