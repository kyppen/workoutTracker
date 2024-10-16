import React, { useState } from "react";
import axios from "axios";

const UsernameForm: React.FC = () => {
    const [username, setUsername] = useState<string>("");
    const [message, setMessage] = useState<string | null>(null);

    // Handler for the form submission
    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();
        try {
            const response = await axios.post("http://localhost:8082/randomplan", {
                username: username,
            });
            setMessage(`Success: ${response.data.message}`);
        } catch (error: any) {
            setMessage(`Error: ${error.response ? error.response.data.message : error.message}`);
        }
    };

    return (
        <form onSubmit={handleSubmit} style={{ maxWidth: "400px", margin: "0 auto" }}>
    <h3>Enter Username</h3>

    {/* Username Input Field */}
    <div style={{ marginBottom: "10px" }}>
    <label htmlFor="username" style={{ display: "block", marginBottom: "5px" }}>
    Username:
        </label>
        <input
    id="username"
    type="text"
    value={username}
    onChange={(e) => setUsername(e.target.value)}
    style={{ width: "100%", padding: "8px", borderRadius: "4px" }}
    required
    />
    </div>

    {/* Submit Button */}
    <button
        type="submit"
    style={{
        width: "100%",
            padding: "10px",
            backgroundColor: "#4CAF50",
            color: "white",
            border: "none",
            borderRadius: "4px",
            cursor: "pointer",
    }}
>
    Submit
    </button>

    {/* Display Message */}
    {message && <p style={{ marginTop: "10px" }}>{message}</p>}
    </form>
    );
    };

    export default UsernameForm;