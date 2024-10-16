import React, { useEffect, useState } from 'react';
import Greeting from './Greeting'
import WorkoutPlan from "./workout";
import axios from "axios";
import RandomWorkoutPlan from "./workout";
import workoutForm from "./WorkoutForm";
import WorkoutForm from "./WorkoutForm";
import UsernameForm from "./postusername";


interface Exercise {
    exerciseId: string;
    sets: number;
    weight: number;
}

interface WorkoutPlan {
    workoutPlanId: string;
    workoutName: string;
    exercises: Exercise[];
}


function FetchGymPlanComponent(){
    const [workoutPlan, setWorkoutPlan] = useState<WorkoutPlan | null>(null);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);

    const fetchWorkoutPlan = async () => {
        setLoading(true);
        setError(null);
        try{
            const response = await axios.post("http://localhost:8083");
            setWorkoutPlan(response.data);
        }catch (err){
            setError("Failed to fetch workoutplan");
        }finally {
            setLoading(false)
        }
    };

  return (
      <div>
          <button onClick={fetchWorkoutPlan}>Get Random Workout Plan</button>

          {loading && <div>Loading...</div>}
          {error && <div>{error}</div>}

          {/* Pass the fetched workoutPlan to RandomWorkoutPlan as a prop */}
          <RandomWorkoutPlan workoutPlan={workoutPlan}/>
      </div>
  );
}


function App() {
    return (
        <div className="App">
            <h1>Workout Tracker and Generator</h1>
            <Greeting greeting={"XD"}/>
            <UsernameForm></UsernameForm>
            <WorkoutForm></WorkoutForm>
            {/* Step 2: Use the DataFetchingComponent */}
            <FetchGymPlanComponent/>
        </div>
    );
}

export default App;
