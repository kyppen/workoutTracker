import React, { useState } from "react";

const equipmentOptions = [
    "medicine ball",
    "dumbbell",
    "body only",
    "bands",
    "kettlebells",
    "foam roll",
    "cable",
    "machine",
    "barbell",
    "exercise ball",
    "e-z curl bar",
    "other"
];

const categoryOptions = [
    "powerlifting",
    "strength",
    "stretching",
    "cardio",
    "olympic weightlifting",
    "strongman",
    "plyometrics"
];

const WorkoutForm: React.FC = () => {
    // State to hold the selected values
    const [equipment, setEquipment] = useState<string[]>([]);
    const [category, setCategory] = useState<string[]>([]);

    // Handler for form submission
    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();
        if (equipment.length > 0 && category.length > 0) {
            console.log(`Selected Equipment: ${equipment}`);
            console.log(`Selected Categories: ${category}`);
            alert(`Selected Equipment: ${equipment.join(", ")}\nSelected Categories: ${category.join(", ")}`);
        } else {
            alert("Please select at least one equipment and one category.");
        }
    };

    // Handle multiple selections
    const handleEquipmentChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedOptions = Array.from(event.target.selectedOptions, (option) => option.value);
        setEquipment(selectedOptions);
    };

    const handleCategoryChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedOptions = Array.from(event.target.selectedOptions, (option) => option.value);
        setCategory(selectedOptions);
    };

    return (
        <form onSubmit={handleSubmit} style={{ maxWidth: "400px", margin: "0 auto" }}>
            <h3>Select Your Workout Preferences</h3>

            {/* Equipment Dropdown (Multi-Select) */}
            <div style={{ marginBottom: "10px" }}>
                <label htmlFor="equipment" style={{ display: "block", marginBottom: "5px" }}>
                    Select Equipment:
                </label>
                <select
                    id="equipment"
                    multiple
                    value={equipment}
                    onChange={handleEquipmentChange}
                    style={{ width: "100%", padding: "8px", borderRadius: "4px", height: "150px" }}
                >
                    {equipmentOptions.map((option, index) => (
                        <option key={index} value={option}>
                            {option}
                        </option>
                    ))}
                </select>
            </div>

            {/* Category Dropdown (Multi-Select) */}
            <div style={{ marginBottom: "10px" }}>
                <label htmlFor="category" style={{ display: "block", marginBottom: "5px" }}>
                    Select Training Categories:
                </label>
                <select
                    id="category"
                    multiple
                    value={category}
                    onChange={handleCategoryChange}
                    style={{ width: "100%", padding: "8px", borderRadius: "4px", height: "150px" }}
                >
                    {categoryOptions.map((option, index) => (
                        <option key={index} value={option}>
                            {option}
                        </option>
                    ))}
                </select>
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
                    cursor: "pointer"
                }}
            >
                Submit
            </button>
        </form>
    );
};

export default WorkoutForm;
