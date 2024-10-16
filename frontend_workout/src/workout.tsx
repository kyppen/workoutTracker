import React from "react";
import Exercise from "./exercise";

// Define TypeScript interfaces for the data structure
interface ExerciseData {

    exerciseId: string;
    sets: number;
    weight: number;
}

interface WorkoutPlan {
    workoutPlanId: string;
    workoutName: string;
    exercises: ExerciseData[];
}

interface RandomWorkoutPlanProps {
    workoutPlan: WorkoutPlan | null;
}

const RandomWorkoutPlan: React.FC<RandomWorkoutPlanProps> = ({ workoutPlan }) => {
    return (
        <div>
            {workoutPlan ? (
                <div>
                    <h1>Workout Plan: {workoutPlan.workoutName}</h1>
                    <ul>
                        {workoutPlan.exercises.map((exercise) => (
                            <li key={exercise.exerciseId}>
                                {/* Render each exercise using the Exercise component */}
                                <Exercise
                                    exerciseId={exercise.exerciseId}
                                    sets={exercise.sets}
                                    weight={exercise.weight}
                                />
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>No workout plan provided.</p>
            )}
        </div>
    );
};

export default RandomWorkoutPlan;