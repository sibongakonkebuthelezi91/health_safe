# HEALTH SAFETY

```mermaid
sequenceDiagram
    participant W as Wearable Device
    participant IS as Ingestion Service
    participant JS as JMS telemetry 
    participant AS as Alert & Notification Service
    participant D as Doctor Dashboard
    
   %% Phase A: Ingestion (Non-Blocking)
    W->>IS: POST /api/v1/readings
    IS->>JS: Publish heart rate reading event
    IS-->>W: 202 Accepted
    
    %% Phase B: Event Evaluation & Notification
    JS->>AS: Deliver telemetry JSON Message
    Note over AS: Check BPM vs Cached Baseline
    
    %% opt Spike Detected (BPM > BaseLine)
    AS->>D: PUSH Alert Event (SSE Stream)
    D->>AS: POST  /api/v1/alerts/{id}/acknowledge
    AS-->>D: 200 ok
    
    

