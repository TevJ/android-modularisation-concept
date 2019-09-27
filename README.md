# Android Modularisation Concept
An app exploring an architecture for modularisation

# Structure
   ![Structure Diagram](https://i.imgur.com/ljYgiMS.png)

Contained in the app layer are the Dagger App component and Android injection modules required to inject all the fragments within the app. It also host the main activity entry point into the app and the top-level nav-graph. It depends on all feature modules.

Below the app module are the feature modules. These contain most of all layers for a single feature, domain, data and presentation. All code related to the implementation of that feature lives in these modules. (These could also be split vertically as well)

Below them is the 'binder' (name TBD) layer. In this layer interfaces are defined for all the UseCases you want to make available for use by other modules and all models you want to make available for use by other modules.

Below this layer is the core layer which contains dependencies used across all modules.

# Reasoning

This type of architecture allows for modules to access data provided by other modules without having to depend on the implementation of how that data is returned. This means, for example, if you were to change the implementation of a UseCase in the weather module without changing the model or method signature then only the weather module and app module would have to be recompiled. However if the implementation of the UseCase also resided within the binder layer then the film module and weather binder would also have to be recompiled as well as the weather module and app module.

# Going forward

I have only just begun looking into dynamically delivered features so I am not currently sure if this architecture would support it. There are also still a lot of questions about how boundaries between features are aligned and what would live in the core layer (I would suggest the core layer is split horizontally into multiple modules).
