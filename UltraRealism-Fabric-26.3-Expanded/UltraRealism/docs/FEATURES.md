# Ultra Realism feature specification

This is the intended feature scope. A catalog entry is a plan, not proof that the feature already exists in-game.

## World and ecology
- Climate zones, seasons, temperature, rain/snow, wind and soil moisture
- Biome-aware animal populations and sustainable spawning
- Plant growth affected by light, water, temperature, soil and fertilizer
- Forestry with regrowth and resource pressure
- Optional ecology settings for low/high simulation intensity

## Food and cooking
- Produce, grains, legumes, meat, fish, eggs, dairy, honey, baked goods and prepared meals
- Cooking stations and multi-step recipes
- Freshness and spoilage; preservation multipliers for drying, salting, smoking, canning and refrigeration
- Nutrition values and configurable food effects
- Food safety should remain fictional/gameplay-oriented, not medical advice

## Materials and building
- Stone families, wood species, metals, alloys, glass, ceramics, paper and polymers
- Properties: hardness, density, durability, conductivity, heat tolerance, moisture response and workability
- Tool wear, repair, quality tiers and material-dependent crafting
- Construction components, insulation, roofing, doors, windows and decorative variants

## Animals
- Wild boar, deer, goats, rabbits, foxes, ducks, additional poultry, frogs and freshwater fish
- Needs: hunger, thirst, fatigue and stress
- Behavior: flee, forage, herd, defend, breed and seek habitat
- Entity persistence, server-authoritative AI, spawn rules, loot balance, model, texture and sound
- Every animal requires a full implementation and in-game test before being marked complete

## Machinery and electricity
- Manual tools, mills, saws, furnaces, presses, conveyors, storage and pipes
- Generator types: hand-crank, fuel, wind, solar and water
- Power consumers: lights, pumps, processing machines, refrigeration and controls
- Network topology, throughput limits, overload handling and persistence
- The current PowerNetwork class is only a deterministic allocation model, not yet a Minecraft cable network

## Water and environment
- Wells, rain collection, tanks, pumps, irrigation and water treatment
- Sewage, composting, sorting, recycling and resource recovery
- Avoid simulating unsafe real-world chemical procedures; chemistry is abstract gameplay

## Vehicles and infrastructure
- Carts, bicycles, tractors, trucks, boats and trains as staged future modules
- Fuel/battery use, capacity, handling, wear and repair
- Roads, bridges, stations, lighting, signs and logistics

## Quality and performance
- Server-authoritative state changes and multiplayer synchronization
- Persist machine inventories, animal needs and freshness state
- Throttle simulations; never tick thousands of objects every tick unnecessarily
- Configurable realism profiles
- Automated unit tests, game launch test, multiplayer test and compatibility checks
