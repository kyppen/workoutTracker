import React, { useState } from "react";
import axios from "axios";
import './exercise.css';  // Optional: Use if you have custom styling

interface ExerciseProps {
    exerciseId: string;
    sets: number;
    weight: number;
}

interface WorkoutDetails {
    id: string;
    name: string;
    force: string;
    level: string;
    mechanic: string;
    equipment: string;
    primaryMuscles: string[];
    secondaryMuscles: string[];
    instructions: string[];
    category: string;
    images: string[];
}

const Exercise: React.FC<ExerciseProps> = ({ exerciseId, sets, weight }) => {
    const [workoutDetails, setWorkoutDetails] = useState<WorkoutDetails | null>(null);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);

    // Function to fetch workout details by exerciseId
    const fetchWorkoutDetails = async () => {
        setLoading(true);
        setError(null);
        try {
            const response = await axios.get(`http://localhost:8082/workout/` + exerciseId);
            console.log(response.data);
            setWorkoutDetails(response.data);
        } catch (err) {
            setError("Failed to fetch workout details");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="exercise-container">
            <p className="exercise-title">Exercise ID: {exerciseId}</p>
            <p className="exercise-details">Sets: {sets}</p>
            <p className="exercise-details">Weight: {weight} kg</p>

            {/* Button to trigger fetching workout details */}
            <button onClick={fetchWorkoutDetails}>View Workout Details</button>

            {loading && <p>Loading workout details...</p>}
            {error && <p>{error}</p>}

            {/* Display workout details if available */}
            {workoutDetails && (
                <div className="workout-details">
                    <h3>{workoutDetails.name}</h3>
                    <p><strong>Force:</strong> {workoutDetails.force}</p>
                    <p><strong>Level:</strong> {workoutDetails.level}</p>
                    <p><strong>Mechanic:</strong> {workoutDetails.mechanic}</p>
                    <p><strong>Equipment:</strong> {workoutDetails.equipment}</p>
                    <p><strong>Category:</strong> {workoutDetails.category}</p>
                    <p><strong>images?:</strong> {workoutDetails.images}</p>

                    <h4>Instructions:</h4>
                    <ol>
                        {workoutDetails.instructions.map((instruction, index) => (
                            <li key={index}>{instruction}</li>
                        ))}
                    </ol>

                </div>
            )}
        </div>
    );
};

export default Exercise;
