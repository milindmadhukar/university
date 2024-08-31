import React from "react";
import "./Display.css";

const Display = ({ formData }) => {
  return (
    <div className="display-container">
      <h1 className="display-heading">Student Details</h1>
      <div className="display-details">
        <p>
          <span className="label">First Name:</span> {formData.fname}
        </p>
        <p>
          <span className="label">Last Name:</span> {formData.lname}
        </p>
        <p>
          <span className="label">Email:</span> {formData.email}
        </p>
        <p>
          <span className="label">Phone:</span> {formData.phone}
        </p>
        <p>
          <span className="label">Address:</span> {formData.address}
        </p>
      </div>
    </div>
  );
};

export default Display;
